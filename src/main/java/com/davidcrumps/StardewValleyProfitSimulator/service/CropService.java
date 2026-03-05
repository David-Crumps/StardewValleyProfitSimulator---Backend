package com.davidcrumps.StardewValleyProfitSimulator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.CropDTO;
import com.davidcrumps.StardewValleyProfitSimulator.mappers.CropMapper;
import com.davidcrumps.StardewValleyProfitSimulator.model.Crop;
import com.davidcrumps.StardewValleyProfitSimulator.repository.CropRepository;

import org.springframework.transaction.annotation.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CropService {
    private final CropRepository repository;
    private final CropMapper mapper;

    @Transactional(readOnly = true)
    public List<CropDTO> getAllCrops() {
        List<Crop> crops = repository.findAllWithSeason();
        return mapper.toCropDtoList(crops);
    }

    public CropDTO getCropById(Long id) {
        Crop crop = repository.findByIdWithEagerSeason(id).orElse(null);
        return mapper.toCropDto(crop);
    }

}
