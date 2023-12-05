package com.example.peliculon.controller;

import com.example.peliculon.model.Comentario;
import com.example.peliculon.model.Pelicula;
import com.example.peliculon.service.ServicioComentarios;
import com.example.peliculon.service.ServicioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;


@Controller
public class Principal {

    @Autowired
    ServicioPeliculas repo;
    @Autowired
    ServicioComentarios repoC;

    @GetMapping("/")
    public String inicio(Model model) {

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
    public String pelicula(Model model, @PathVariable long id) {
        Pelicula p = repo.findById(id);
        model.addAttribute("pelicula", p);
        model.addAttribute("comentarios", repoC.findByPelicula(p));
        model.addAttribute("nuevoComentario", new Comentario());

        return "detalle";

    }

    @PostMapping("/comentario/add")
    public String guardarComentario(@ModelAttribute("nuevoComentario") Comentario comentario, @RequestParam long idPelicula){
        comentario.setFecha(LocalDate.now());
        //"Localizo" la película que tiene el id que me han pasado en el campo hidden del formulario
        Pelicula pelicula=repo.findById(idPelicula);
        //Al comentario le asigno la película
        comentario.setPelicula(pelicula);
        repoC.save(comentario);
        return "redirect:/pelicula/" + comentario.getPelicula().getId();
    }

    @GetMapping("/comentario/delete/{id}")
    public String borrarComentario(@PathVariable long id, Model model) {
        Comentario p = repoC.findById(id);
        repoC.delete(p);
        return "redirect:/pelicula/" +p.getPelicula().getId();
    }

}
