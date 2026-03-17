package com.davidcrumps.StardewValleyProfitSimulator.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.ErrorMessageDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handlEntityNotFound(EntityNotFoundException ex) {
        ErrorMessageDTO error = new ErrorMessageDTO("Not Found", ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}

