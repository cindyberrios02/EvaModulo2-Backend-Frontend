package com.uniandes.calificacionesfrontend.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        Map<String, String> response = new HashMap<>();

        if (ex.getMessage() != null && ex.getMessage().contains("uk_lw56kqq7wus1n1tx3k0p725f0")) {
            response.put("error", "Error de validación");
            response.put("message", "El RUT ingresado ya existe en el sistema");
        } else {
            response.put("error", "Error de validación");
            response.put("message", "Error al guardar los datos. Verifique la información ingresada");
        }

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "Error del servidor");
        response.put("message", "Ocurrió un error inesperado. Por favor, intente nuevamente.");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}