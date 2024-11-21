package com.uniandes.calificaciones.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")  // Esto define la ruta base /api/test
public class TestController {

    // GET http://localhost:8081/api/test/public
    @GetMapping("/public")
    public String publicEndpoint() {
        return "Este es un endpoint público";
    }

    // GET http://localhost:8081/api/test/private
    @GetMapping("/private")
    public String privateEndpoint() {
        return "Este es un endpoint privado - necesitas estar autenticado";
    }
}