package com.davidcrumps.StardewValleyProfitSimulator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.CropQualityDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseRequestDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseResponseDTO;
import com.davidcrumps.StardewValleyProfitSimulator.mappers.PurchaseMapper;
import com.davidcrumps.StardewValleyProfitSimulator.model.Crop;
import com.davidcrumps.StardewValleyProfitSimulator.model.Purchase;
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
        System.out.println("Farming Level: " +request.getFarmingLevel());
        System.out.println("Fertilizer Level: " +request.getFertilizer());
        CropQualityDTO numByQual = calculateQuality(request.getQuantity(), request.getFertilizer(), request.getFarmingLevel());
        System.out.println("GOLD: "+ numByQual.getGold());
        System.out.println("SILVER: "+ numByQual.getSilver());
        System.out.println("NORMAL: "+ numByQual.getNormal());
        
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
        return new CropQualityDTO(numGold, numSilver, numNormal);
    }


}

// For a given crop to determine its profits we need to know that following ->
//if the person marks the plant to regrow (for single harvest crops this means repurchasing) -> update DTO

//number of harvests -> (my formula from python is best!) -> determine after intial growth period how many days are left, then with that determine how many regrows can occur in that time and then add 1 to that, to account for intial growth period
// 

//get fertilizer value (create a single fertilizer table, each fertilizer holds a quality value (0 - 3), and a speed multiplier (1.0, 1.1, 1.25, 1.33))
//get farming level
//determine the quality of crops given the amount purchased (not amount gained from harvesting, since crops like blueberries additional drops are ALWAYS normal) [DONE]
//determine cost
//determine estimated profit