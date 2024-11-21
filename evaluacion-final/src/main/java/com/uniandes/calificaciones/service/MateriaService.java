package com.uniandes.calificaciones.service;

import com.uniandes.calificaciones.model.Materia;
import com.uniandes.calificaciones.repository.MateriaRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MateriaService {

    private static final Logger logger = LoggerFactory.getLogger(MateriaService.class);
    private final MateriaRepository materiaRepository;

    public Materia save(Materia materia) {
        logger.info("Guardando materia: {}", materia.getNombre());
        return materiaRepository.save(materia);
    }
}