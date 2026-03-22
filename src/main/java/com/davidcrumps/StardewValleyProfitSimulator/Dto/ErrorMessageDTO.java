package com.davidcrumps.StardewValleyProfitSimulator.Dto;

import java.time.Instant;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ErrorMessageDTO {
    private String error;
    private List<String> messages;
    private String path;
    private Instant timestamp;

    public ErrorMessageDTO(String error, List<String> messages, String path) {
        this.error = error;
        this.messages = messages;
        this.path = path;
        this.timestamp = Instant.now();
    }
}
