package com.uniandes.calificaciones.exception;

import org.springframework.security.core.AuthenticationException;

public class CustomSecurityException extends AuthenticationException {

    private static final long serialVersionUID = 1L;

    public CustomSecurityException(String message) {
        super(message);
    }
}