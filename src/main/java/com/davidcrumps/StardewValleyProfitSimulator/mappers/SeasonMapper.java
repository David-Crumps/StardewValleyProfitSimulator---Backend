package com.davidcrumps.StardewValleyProfitSimulator.mappers;

import java.util.List;
import java.util.Set;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.SeasonCropDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.SeasonDTO;
import com.davidcrumps.StardewValleyProfitSimulator.model.Crop;
import com.davidcrumps.StardewValleyProfitSimulator.model.Season;

@Mapper(componentModel = "spring")
public interface SeasonMapper {
    SeasonDTO toSeasonDto(Season season);
    List<SeasonDTO> toSeasonDtoList(List<Season> seasons);

    @Mapping(target = "crops", source = "crops")
    SeasonCropDTO toSeasonCropDTO(Season season);
    List<SeasonCropDTO> toSeasonCropDtoList(List<Season> seasons);

    default List<String> mapCropsToNames(Set<Crop> crops) {
        return crops.stream().map(Crop::getName).toList();
    }
}
