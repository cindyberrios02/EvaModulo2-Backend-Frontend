package com.uniandes.calificaciones.service;

import com.uniandes.calificaciones.model.Alumno;
import com.uniandes.calificaciones.repository.AlumnoRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlumnoService {

    private static final Logger logger = LoggerFactory.getLogger(AlumnoService.class);
    private final AlumnoRepository alumnoRepository;

    public Alumno save(Alumno alumno) {
        logger.info("Guardando alumno: {}", alumno.getNombre());
        return alumnoRepository.save(alumno);
    }

    public List<Alumno> findAll() {
        logger.info("Buscando todos los alumnos");
        return alumnoRepository.findAll();
    }
}