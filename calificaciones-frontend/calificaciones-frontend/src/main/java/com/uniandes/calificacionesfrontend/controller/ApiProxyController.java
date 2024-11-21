package com.uniandes.calificacionesfrontend.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ApiProxyController {

    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    @PostMapping("/alumnos")
    public ResponseEntity<?> createAlumno(@RequestBody Object alumno, HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> request = new HttpEntity<>(alumno, headers);
        return restTemplate.exchange(
                apiUrl + "/api/alumnos",
                HttpMethod.POST,
                request,
                Object.class
        );
    }

    @PostMapping("/materias")
    public ResponseEntity<?> createMateria(@RequestBody Object materia, HttpSession session) {
        String token = (String) session.getAttribute("token");
        if (token == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<?> request = new HttpEntity<>(materia, headers);
        return restTemplate.exchange(
                apiUrl + "/api/materias",
                HttpMethod.POST,
                request,
                Object.class
        );
    }
}