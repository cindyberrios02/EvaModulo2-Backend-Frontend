package com.uniandes.calificacionesfrontend.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {

    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    public String signin(String username, String password) {
        String url = apiUrl + "/auth/signin";
        log.info("Intentando autenticar en: {}", url);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, String> body = new HashMap<>();
        body.put("username", username);
        body.put("password", password);

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        try {
            log.info("Enviando petición de login para usuario: {}", username);
            ResponseEntity<Map> response = restTemplate.exchange(
                    url,
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                log.info("Login exitoso para usuario: {}", username);
                return (String) response.getBody().get("token");
            }

            log.error("Error en respuesta del servidor: {}", response.getStatusCode());
            throw new RuntimeException("Error en autenticación");

        } catch (Exception e) {
            log.error("Error al conectar con el servidor de autenticación", e);
            throw new RuntimeException("Error de conexión con el servidor");
        }
    }
}