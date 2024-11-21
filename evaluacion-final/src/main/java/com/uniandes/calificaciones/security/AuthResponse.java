package com.uniandes.calificaciones.security;

public record AuthResponse(
        String username,
        String token
) {}