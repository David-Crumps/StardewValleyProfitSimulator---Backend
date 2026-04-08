package com.davidcrumps.StardewValleyProfitSimulator.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.davidcrumps.StardewValleyProfitSimulator.model.Fertilizer;
import com.davidcrumps.StardewValleyProfitSimulator.repository.FertilizerRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FertilizerService {
    private final FertilizerRepository repository;

    public List<Fertilizer> getAllFertilizer() {
        return repository.findAll();
    }

    public Fertilizer getFertilizerById(Long id) {
        Fertilizer fert = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Fertilizer not found with id: "+ id));
        return fert;
    }

}
