package com.davidcrumps.StardewValleyProfitSimulator.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.CropDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.CropSummaryDTO;
import com.davidcrumps.StardewValleyProfitSimulator.model.Crop;


@Mapper(componentModel =  "spring", uses = SeasonMapper.class)
public interface CropMapper {
    CropDTO toCropDto(Crop crop);
    List<CropDTO> toCropDtoList(List<Crop> crops);

    CropSummaryDTO toCropSummaryDTO(Crop crop);
    List<CropSummaryDTO> toCropSummaryDTOsList(List<Crop> crops);
}
