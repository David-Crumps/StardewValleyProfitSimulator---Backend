package com.davidcrumps.StardewValleyProfitSimulator.Dto;

import lombok.Data;

@Data
public class PurchaseResponseDTO {
    CropDTO crop;
    int totalCost;
}
