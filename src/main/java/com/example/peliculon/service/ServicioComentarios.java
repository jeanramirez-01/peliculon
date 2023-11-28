package com.example.peliculon.service;

import com.example.peliculon.model.Comentario;
import com.example.peliculon.model.Pelicula;
import com.example.peliculon.repository.RepositorioComentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioComentarios {

    @Autowired
    RepositorioComentarios repo;
    public ArrayList<Comentario> findAll(){
        return repo.findAll();
    }
    public Comentario save(Comentario comentario){
        return repo.save(comentario);
    }
    public Comentario findById(long id){
        return repo.findById(id);
    }
    public ArrayList<Comentario> findByPelicula(Pelicula pelicula){
        return repo.findByPelicula(pelicula);
    }

    public void delete(Comentario comentario){
        repo.delete(comentario);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }

}
