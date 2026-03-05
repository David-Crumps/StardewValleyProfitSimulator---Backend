package com.davidcrumps.StardewValleyProfitSimulator.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseRequestDTO;
import com.davidcrumps.StardewValleyProfitSimulator.Dto.PurchaseResponseDTO;
import com.davidcrumps.StardewValleyProfitSimulator.service.PurchaseService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/purchases")
public class PurchaseController {
    private final PurchaseService service;

    @PostMapping("/")
    public ResponseEntity<PurchaseResponseDTO> addPurchase(@RequestBody PurchaseRequestDTO request) {
        return new ResponseEntity<>(service.addProduct(request), HttpStatus.CREATED);
    }

}
