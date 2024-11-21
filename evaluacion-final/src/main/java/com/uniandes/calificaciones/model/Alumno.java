package com.uniandes.calificaciones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "alumnos")
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El RUT es obligatorio")
    @Column(unique = true)
    private String rut;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @NotBlank(message = "La dirección es obligatoria")
    private String direccion;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Materia> materiaList = new HashSet<>();

    // Métodos helper para mantener la sincronización bidireccional
    public void addMateria(Materia materia) {
        materiaList.add(materia);
        materia.setAlumno(this);
    }

    public void removeMateria(Materia materia) {
        materiaList.remove(materia);
        materia.setAlumno(null);
    }
}