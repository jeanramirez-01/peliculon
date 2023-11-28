package com.example.peliculon.controller;

import com.example.peliculon.model.Pelicula;
import com.example.peliculon.service.ServicioComentarios;
import com.example.peliculon.service.ServicioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class Principal {

    @Autowired
    ServicioPeliculas repo;
    @Autowired
    ServicioComentarios repoC;

    @GetMapping("/")
    public String inicio(Model model){

//        ArrayList<Pelicula> p = repo.findAll();
//        model.addAttribute("lista",p);
        model.addAttribute("cartelera", repo.findAll());
        return "index";
    }
    @GetMapping("/detalle/{id}")
    public String findById(Model model, @PathVariable long id) {
        Pelicula n = repo.findById(id);
        model.addAttribute("cartelera", n);
        model.addAttribute("comentarios", repoC.findByPelicula(n));
        return "detalle";
    }

    @GetMapping("/pelicula/{id}")
    public String pelicula(Model model, @PathVariable long id){

        return "";

    }


}
