package com.uniandes.calificaciones.repository;

import com.uniandes.calificaciones.model.Alumno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    Optional<Alumno> findByRut(String rut);

    boolean existsByRut(String rut);

    // Buscar alumnos por nombre (búsqueda parcial, case insensitive)
    List<Alumno> findByNombreContainingIgnoreCase(String nombre);

    // Buscar alumnos que tengan una materia específica
    @Query("SELECT DISTINCT a FROM Alumno a JOIN a.materiaList m WHERE LOWER(m.nombre) = LOWER(:nombreMateria)")
    List<Alumno> findByMateriaNombre(@Param("nombreMateria") String nombreMateria);

    // Contar cuántas materias tiene un alumno
    @Query("SELECT COUNT(m) FROM Alumno a JOIN a.materiaList m WHERE a.id = :alumnoId")
    Long countMateriasByAlumnoId(@Param("alumnoId") Long alumnoId);
}