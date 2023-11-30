package com.example.peliculon.repository;

import com.example.peliculon.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;

@Repository
public interface RepositorioPeliculas extends JpaRepository<Pelicula, Long> {

    public ArrayList<Pelicula> findAll();
    public Pelicula findById(long id);
    public Pelicula save(Pelicula pelicula);

    public ArrayList<Pelicula> findByNacionalidad(String nacionalidad);
}
