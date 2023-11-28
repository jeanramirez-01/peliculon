package com.example.peliculon.controller;

import com.example.peliculon.model.Pelicula;
import com.example.peliculon.service.ServicioPeliculas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class Crud {

    @Autowired
    private ServicioPeliculas serv;

    @GetMapping("/crud")
    public String listadoPeliculas(Model model) {
        model.addAttribute("peliculas", serv.findAll());
        return "crud";
    }

    //Muestra el formulario para añadir películas, AUN NO LA AÑADE
    @GetMapping("/crud/add")
    public String addPelicula(Model model) {
        model.addAttribute("formPelicula", new Pelicula());
        return "form_add";
    }

    @PostMapping("/crud/save")
    public String guardarPelicula(@ModelAttribute("formPelicula") Pelicula nuevaPelicula) {

        serv.save(nuevaPelicula);

        return "redirect:/add";
    }

    @GetMapping("/crud/update/{id}")
    public String muestraPelicula(@PathVariable long id, Model model) {
        Pelicula p = serv.findById(id);
        model.addAttribute("form_pelicula", p);
        return "form_add";
    }

    @PostMapping("/crud/modificar")
    public String modificarPelicula(@ModelAttribute("formPelicula") Pelicula p) {

        serv.save(p);

        return "redirect:/crud";
    }

    @GetMapping("/crud/delete/{id}")
    public String borrarPelicula(@PathVariable long id, Model model) {
        Pelicula p = serv.findById(id);
        serv.delete(p);
        return "redirect:/crud";
    }

}