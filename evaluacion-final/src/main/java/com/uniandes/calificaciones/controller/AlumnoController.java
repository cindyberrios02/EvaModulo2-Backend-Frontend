package com.uniandes.calificaciones.controller;

import com.uniandes.calificaciones.model.Alumno;
import com.uniandes.calificaciones.service.AlumnoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alumnos")
@RequiredArgsConstructor
public class AlumnoController {

    private final AlumnoService alumnoService;

    @GetMapping
    public ResponseEntity<List<Alumno>> findAll() {
        return ResponseEntity.ok(alumnoService.findAll());
    }

    @PostMapping
    public ResponseEntity<Alumno> save(@RequestBody Alumno alumno) {
        return ResponseEntity.ok(alumnoService.save(alumno));
    }
}