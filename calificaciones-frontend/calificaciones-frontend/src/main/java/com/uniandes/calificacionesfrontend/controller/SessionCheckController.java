package com.uniandes.calificacionesfrontend.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class SessionCheckController {

    @GetMapping("/api/check-session")
    public Map<String, Object> checkSession(HttpSession session) {
        Map<String, Object> response = new HashMap<>();
        String token = (String) session.getAttribute("token");
        String username = (String) session.getAttribute("username");

        response.put("hasToken", token != null);
        response.put("username", username);
        if (token != null) {
            response.put("tokenLength", token.length());
        }

        return response;
    }
}