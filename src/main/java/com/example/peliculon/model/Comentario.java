package com.example.peliculon.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comentarios")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String contenido;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    @ManyToOne(cascade = CascadeType.ALL)
    private Pelicula pelicula;
}
