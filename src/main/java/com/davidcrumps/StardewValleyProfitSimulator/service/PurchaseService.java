package com.davidcrumps.StardewValleyProfitSimulator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.CropQualityDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseRequestDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseResponseDTO;
import com.davidcrumps.StardewValleyProfitSimulator.enums.SeasonEnum;
import com.davidcrumps.StardewValleyProfitSimulator.exception.InvalidSeasonException;
import com.davidcrumps.StardewValleyProfitSimulator.mappers.PurchaseMapper;
import com.davidcrumps.StardewValleyProfitSimulator.model.Crop;
import com.davidcrumps.StardewValleyProfitSimulator.model.Purchase;
import com.davidcrumps.StardewValleyProfitSimulator.model.Season;
import com.davidcrumps.StardewValleyProfitSimulator.repository.CropRepository;
import com.davidcrumps.StardewValleyProfitSimulator.repository.PurchaseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PurchaseService {

    private final PurchaseRepository purchaseRepository;
    private final CropRepository cropRepository;
    private final PurchaseMapper mapper;

    public PurchaseResponseDTO addProduct(PurchaseRequestDTO request) { 
        Crop crop = cropRepository.findByIdWithEagerSeason(request.getCropId()).orElseThrow(() -> new EntityNotFoundException("Crop not found with id " + request.getCropId()));

        if (crop.getSeasons().stream().noneMatch(s -> s.getSeasonEnum() == request.getSeasonPlanted())) {
            throw new InvalidSeasonException("Crop cannot be planted in " + request.getSeasonPlanted());
        }
        int numHarv = numHarvests(crop, crop.getSeasons(), request.getDayPlanted(), request.getSeasonPlanted());

        /*CropQualityDTO numByQual = calculateQuality(request.getQuantity(), request.getFertilizer(), request.getFarmingLevel());
        System.out.println("GOLD: "+ numByQual.getGold());
        System.out.println("SILVER: "+ numByQual.getSilver());
        System.out.println("NORMAL: "+ numByQual.getNormal());*/
        
        Purchase purchase = Purchase.builder().crop(crop).totalCost(request.getQuantity()*crop.getSeedCost()).build();
        purchaseRepository.save(purchase);
        return mapper.toDto(purchase);
    }

    private CropQualityDTO calculateQuality(int quantity, int fertilizer, int farmingLevel) {
        double goldChanceRaw = (0.2 * (farmingLevel/10.0)) + (0.2 * fertilizer * ((farmingLevel+2)/12.0)) + 0.01;
        BigDecimal goldChanceBD = BigDecimal.valueOf(goldChanceRaw).setScale(2, RoundingMode.HALF_UP);
        double goldChance = goldChanceBD.doubleValue();

        int numGold = 0;
        for (int i = 0; i < quantity; i++) {
            double rand = ThreadLocalRandom.current().nextDouble();
            if (rand < goldChance) numGold++;
        } 

        double silverChanceRaw = (Math.min(0.75, goldChance*2));
        BigDecimal silverChanceBD = BigDecimal.valueOf(silverChanceRaw).setScale(2, RoundingMode.HALF_UP);
        double silverChance = silverChanceBD.doubleValue();

        int silverQuantity = quantity - numGold;
        int numSilver = 0;
        for (int i = 0; i < silverQuantity; i++) {
            double rand = ThreadLocalRandom.current().nextDouble();
            if (rand < silverChance) numSilver++;
        }

        int numNormal = silverQuantity - numSilver;
        //CONSIDER ADDING nomNormal += (crop.getCropsPerHarvest-1)*quantity (blueberries are 3.02 crops per harvest so add on the remaining 2.02 to normal quantity)
        //for CROPS with only one crop per harvest you get (1-1)*quantity which is 0
        return new CropQualityDTO(numGold, numSilver, numNormal);
    }

    //note this only works for crops designated to be selected to be regrown across their respective seasons
    private int numHarvests(Crop crop, List<Season> seasons, int dayPlanted, SeasonEnum seasonPlanted) {
        List<SeasonEnum> validSeasons = crop.getSeasons().stream().map(Season::getSeasonEnum).sorted(Comparator.comparingInt(SeasonEnum::getOrder)).toList();
        int startIndex = validSeasons.indexOf(seasonPlanted);

        int days = 0, remainderDays = 0, total = 0, daysInSeason = 28;
        for (int i = startIndex; i < validSeasons.size(); i++) {
            if (remainderDays > 0) days = daysInSeason - remainderDays;
            else days = daysInSeason - dayPlanted - crop.getGrowTime(); //when speed fertilizer is created crop.getGrowTime() will be updated.cropController
            
            if (days < 0) { 
                remainderDays = Math.abs(days);
            }
            else {
                double num_harvests = 0;
                if (crop.getRegrowthTime() > 0) {
                    num_harvests = (double) days/crop.getRegrowthTime();
                    remainderDays = Math.max(1, (int)(crop.getRegrowthTime()*(1-(num_harvests%1)))); //the remainder should always be atleast 1.
                } else {
                    num_harvests = (double) days/crop.getGrowTime();
                }
                total += ((int) num_harvests + 1);
            }
        }
        System.out.println(total);
        return 5;
    }


}

// For a given crop to determine its profits we need to know that following ->
//if the person marks the plant to regrow (for single harvest crops this means repurchasing) -> update DTO -> need a boolean setToRegrow;


//get fertilizer value (create a single fertilizer table, each fertilizer holds a quality value (0 - 3), and a speed multiplier (1.0, 1.1, 1.25, 1.33))
//determine cost
//determine estimated profit