package com.example.peliculon.service;

import com.example.peliculon.model.Pelicula;
import com.example.peliculon.repository.RepositorioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ServicioPeliculas {

    @Autowired
    RepositorioPeliculas repo;

    public ArrayList<Pelicula> findAll() {
        return repo.findAll();
    }

    public Pelicula findById(long id) {
        return repo.findById(id);
    }

    public Pelicula save(Pelicula p){
        return repo.save(p);
    }

    public void delete(Pelicula p){
        repo.delete(p);
    }

    public void deleteById(long id){
        repo.deleteById(id);
    }
}
