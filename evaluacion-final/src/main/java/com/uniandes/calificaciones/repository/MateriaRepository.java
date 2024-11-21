package com.uniandes.calificaciones.repository;

import com.uniandes.calificaciones.model.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
    // Buscar materias por nombre (búsqueda exacta)
    List<Materia> findByNombre(String nombre);

    // Buscar materias por nombre (búsqueda parcial)
    List<Materia> findByNombreContainingIgnoreCase(String nombre);

    // Buscar materias por alumno
    List<Materia> findByAlumnoId(Long alumnoId);

    // Contar cuántos alumnos tienen una materia específica
    @Query("SELECT COUNT(DISTINCT m.alumno) FROM Materia m WHERE LOWER(m.nombre) = LOWER(:nombreMateria)")
    Long countAlumnosByMateriaNombre(@Param("nombreMateria") String nombreMateria);

    // Verificar si existe una materia con ese nombre para un alumno específico
    boolean existsByNombreAndAlumnoId(String nombre, Long alumnoId);
}