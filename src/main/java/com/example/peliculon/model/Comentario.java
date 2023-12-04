package com.example.peliculon.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Pelicula pelicula;
}
