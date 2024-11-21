package com.uniandes.calificacionesfrontend.service;

import com.uniandes.calificacionesfrontend.dto.AlumnoDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlumnoService {

    private final RestTemplate restTemplate;

    @Value("${api.url}")
    private String apiUrl;

    public List<AlumnoDTO> findAll(String token) {
        String url = apiUrl + "/api/alumnos";

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));

        HttpEntity<?> entity = new HttpEntity<>(headers);

        ResponseEntity<List<AlumnoDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                entity,
                new ParameterizedTypeReference<List<AlumnoDTO>>() {}
        );

        return response.getBody();
    }
}