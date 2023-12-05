package com.example.peliculon.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.ArrayList;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String titulo;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String sinopsis;
    @DateTimeFormat(pattern = "dd/MM/YYYY")
    private LocalDate fecha;
    private String nacionalidad;
    private String imagen;
    @Column(columnDefinition = "TEXT")
    private String trailer;
//    @OneToMany
//    private ArrayList<Comentario> comentarios = new ArrayList<>();


}