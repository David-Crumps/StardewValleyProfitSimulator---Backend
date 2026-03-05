package com.davidcrumps.StardewValleyProfitSimulator.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.SeasonCropDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.SeasonDTO;
import com.davidcrumps.StardewValleyProfitSimulator.service.SeasonService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/seasons")
public class SeasonController {
    private final SeasonService service;

    @GetMapping("/names")
    public ResponseEntity<List<SeasonDTO>> getAllSeasonNames() {
        return new ResponseEntity<>(service.getAllSeasonNames(), HttpStatus.OK);

    }

    @GetMapping("/")
    public ResponseEntity<List<SeasonCropDTO>> getAllSeasonsWithCrops() {
        return new ResponseEntity<>(service.getAllSeasonsWithCrops(), HttpStatus.OK);
    }

}
