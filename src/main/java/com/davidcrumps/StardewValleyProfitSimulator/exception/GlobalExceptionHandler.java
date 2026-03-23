package com.davidcrumps.StardewValleyProfitSimulator.exception;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.davidcrumps.StardewValleyProfitSimulator.Dto.ErrorMessageDTO;

import jakarta.persistence.EntityNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorMessageDTO> handlEntityNotFound(EntityNotFoundException ex, WebRequest request) {
        ErrorMessageDTO error = new ErrorMessageDTO("Not Found", List.of(ex.getMessage()), request.getDescription(false));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(InvalidSeasonException.class) 
    public ResponseEntity<ErrorMessageDTO> handleInvalidSeason(InvalidSeasonException ex, WebRequest request) {
        ErrorMessageDTO error = new ErrorMessageDTO("Invalid Season", List.of(ex.getMessage()), request.getDescription(false));
        return ResponseEntity.badRequest().body(error);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<String> messages = ex.getBindingResult().getFieldErrors().stream().map(error -> error.getField()+ ": " + error.getDefaultMessage()).toList();

        ErrorMessageDTO errorResponse = new ErrorMessageDTO("Validation Failed", messages, request.getDescription(false));
        return ResponseEntity.badRequest().body(errorResponse);
    }

}

