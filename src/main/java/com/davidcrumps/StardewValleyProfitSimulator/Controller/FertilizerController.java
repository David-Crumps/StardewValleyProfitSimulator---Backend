package com.davidcrumps.StardewValleyProfitSimulator.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcrumps.StardewValleyProfitSimulator.model.Fertilizer;
import com.davidcrumps.StardewValleyProfitSimulator.service.FertilizerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/fertilizer")
public class FertilizerController {
    private final FertilizerService service;

    @GetMapping("/")
    public ResponseEntity<List<Fertilizer>> getAllFertilizer() {
        return new ResponseEntity<>(service.getAllFertilizer(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fertilizer> getFertlizerById(@PathVariable Long id) {
        Fertilizer fert = service.getFertilizerById(id);
        return new ResponseEntity<>(fert, HttpStatus.OK);
    }

}
