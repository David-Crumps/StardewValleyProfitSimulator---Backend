package com.davidcrumps.StardewValleyProfitSimulator.Dto;

import com.davidcrumps.StardewValleyProfitSimulator.enums.SeasonEnum;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseRequestDTO {
    private long cropId;

    @Min(value = 1, message = "Cannot purchase less than 1 crop")
    private Integer quantity;

    @NotNull(message = "No value found")
    @Min(value = 0, message = "Cannot be negative")
    @Max(value = 4, message = "Cannot exceed 4")
    private Integer fertilizer;

    @NotNull(message = "No value found")
    @Min(value = 0, message = "Cannot be negative")
    @Max(value = 10, message = "Cannot exceed 10")
    private Integer farmingLevel;

    @NotNull(message = "No value found")
    @Min(value = 1, message = "First day of the season is 1")
    @Max(value = 28, message = "Last day of the season is 28")
    private Integer dayPlanted;

    @NotNull(message = "No value found")
    private SeasonEnum seasonPlanted;
}
