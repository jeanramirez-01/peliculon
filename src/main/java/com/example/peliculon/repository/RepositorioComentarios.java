package com.example.peliculon.repository;

import com.example.peliculon.model.Comentario;
import com.example.peliculon.model.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface RepositorioComentarios extends JpaRepository<Comentario, Long> {

    public ArrayList<Comentario> findAll();
    public Comentario findById(long id);
    public ArrayList<Comentario> findByPelicula(Pelicula p);
    public Comentario save(Comentario c);

}
