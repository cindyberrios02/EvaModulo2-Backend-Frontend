package com.uniandes.calificaciones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "materias")
public class Materia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_id")
    @JsonIgnore // Para evitar ciclos infinitos en la serialización
    private Alumno alumno;

    // Constructor por defecto requerido por JPA
    public Materia() {
    }

    // Constructor con nombre
    public Materia(String nombre) {
        this.nombre = nombre;
    }
}