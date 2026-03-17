package com.davidcrumps.StardewValleyProfitSimulator.service;

import org.springframework.stereotype.Service;

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
        Purchase purchase = Purchase.builder().crop(crop).totalCost(request.getQuantity()*crop.getSeedCost()).build();
        purchaseRepository.save(purchase);
        return mapper.toDto(purchase);
    }

}
