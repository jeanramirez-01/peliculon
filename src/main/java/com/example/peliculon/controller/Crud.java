package com.example.peliculon.controller;

import com.example.peliculon.model.Pelicula;
import com.example.peliculon.service.ServicioPeliculas;
import com.example.peliculon.storage.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

@Controller
public class Crud {

    @Autowired
    private ServicioPeliculas serv;

    @Autowired
    public StorageService storageService;

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
    public String guardarPelicula(@ModelAttribute("formPelicula") Pelicula nuevaPelicula,
                                  @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            String imagen = storageService.store(file, nuevaPelicula.getTitulo());
            System.out.println("La imagen a guardar es : " + imagen);
            nuevaPelicula.setImagen(MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "serveFile", imagen).build().toUriString());
        }

        serv.save(nuevaPelicula);

        return "redirect:/add";
    }

    @GetMapping("/crud/update/{id}")
    public String muestraPelicula(@PathVariable long id, Model model) {
        Pelicula p = serv.findById(id);
        model.addAttribute("formPelicula", p);
        return "form_add";
    }

    @PostMapping("/crud/modificar")
    public String modificarPelicula(@ModelAttribute("formPelicula") Pelicula p,
                                    @RequestParam("file") MultipartFile file) {

        if (!file.isEmpty()) {
            String imagen = storageService.store(file, p.getTitulo());
            System.out.println("La imagen a guardar es : " + imagen);
            p.setImagen(MvcUriComponentsBuilder
                    .fromMethodName(FileUploadController.class, "serveFile", imagen).build().toUriString());
        }

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