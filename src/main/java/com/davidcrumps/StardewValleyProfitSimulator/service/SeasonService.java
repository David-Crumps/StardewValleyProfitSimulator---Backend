package com.davidcrumps.StardewValleyProfitSimulator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.SeasonCropDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.SeasonDTO;
import com.davidcrumps.StardewValleyProfitSimulator.mappers.SeasonMapper;
import com.davidcrumps.StardewValleyProfitSimulator.repository.SeasonRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SeasonService {
    private final SeasonRepository repository;
    private final SeasonMapper mapper;

    public List<SeasonDTO> getAllSeasonNames() {
       return mapper.toSeasonDtoList(repository.findAll());
    }

    public List<SeasonCropDTO> getAllSeasonsWithCrops() {
        return mapper.toSeasonCropDtoList(repository.findAllWithCrops());
    }

}
