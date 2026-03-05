package com.davidcrumps.StardewValleyProfitSimulator.Dto;

import java.util.List;

import lombok.Data;

@Data
public class CropDTO {
    private long id;
    private String name;
    private int seedCost;
    private int seedSellPrice;
    private int growTime;
    private int regrowthTime;
    private int cropsPerHarvest;
    private List<SeasonDTO> seasons;
    private String ImageUrl;
}
