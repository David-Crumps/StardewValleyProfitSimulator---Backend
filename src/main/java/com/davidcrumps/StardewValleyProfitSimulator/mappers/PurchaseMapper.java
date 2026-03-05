package com.davidcrumps.StardewValleyProfitSimulator.mappers;

import org.mapstruct.Mapper;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseResponseDTO;
import com.davidcrumps.StardewValleyProfitSimulator.model.Purchase;

@Mapper(componentModel = "spring", uses = CropMapper.class)
public interface PurchaseMapper {
    PurchaseResponseDTO toDto(Purchase purchase);
}
