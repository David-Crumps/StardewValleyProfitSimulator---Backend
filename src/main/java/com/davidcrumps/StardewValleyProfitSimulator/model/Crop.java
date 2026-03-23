package com.davidcrumps.StardewValleyProfitSimulator.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OrderBy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Crop {
    @Id
    private Long id;
    private String name;
    private Integer seedCost;
    private Integer seedSellPrice;
    private Integer growTime;
    private Integer regrowthTime;
    private Double cropsPerHarvest;

    @ManyToMany
    @JoinTable(
        name = "crop_season",
        joinColumns = @JoinColumn(name = "crop_id"),
        inverseJoinColumns = @JoinColumn(name = "season_id")
    )
    @OrderBy("id ASC")
    private List<Season> seasons;

    private Integer cropSellPrice;

    private String ImageUrl;
}
