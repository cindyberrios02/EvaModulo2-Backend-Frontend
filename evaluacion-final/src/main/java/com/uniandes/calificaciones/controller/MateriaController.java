package com.uniandes.calificaciones.controller;

import com.uniandes.calificaciones.model.Materia;
import com.uniandes.calificaciones.service.MateriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/materias")
@RequiredArgsConstructor
public class MateriaController {

    private final MateriaService materiaService;

    @PostMapping
    public ResponseEntity<Materia> save(@RequestBody Materia materia) {
        return ResponseEntity.ok(materiaService.save(materia));
    }
}