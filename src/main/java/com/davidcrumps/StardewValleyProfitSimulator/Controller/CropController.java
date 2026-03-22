package com.davidcrumps.StardewValleyProfitSimulator.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.CropDTO;
import com.davidcrumps.StardewValleyProfitSimulator.service.CropService;

import lombok.AllArgsConstructor;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/api/crops")
public class CropController {
    private final CropService service;

    @GetMapping("/")
    public ResponseEntity<List<CropDTO>> getAllCrops() {
        return new ResponseEntity<>(service.getAllCrops(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CropDTO> getCropById(@PathVariable Long id) {
        CropDTO cropDto = service.getCropById(id);
        return new ResponseEntity<>(cropDto, HttpStatus.OK);
    }

}
