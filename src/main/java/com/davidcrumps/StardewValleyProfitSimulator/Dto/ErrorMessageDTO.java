package com.davidcrumps.StardewValleyProfitSimulator.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageDTO {
    private String error;
    private String message;
}
