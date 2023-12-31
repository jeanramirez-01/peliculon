package com.example.peliculon;

import com.example.peliculon.model.Comentario;
import com.example.peliculon.model.Pelicula;
import com.example.peliculon.service.ServicioComentarios;
import com.example.peliculon.service.ServicioPeliculas;
import com.example.peliculon.storage.StorageProperties;
import com.example.peliculon.storage.StorageService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Locale;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class PeliculonApplication {

//	@Autowired
//	ServicioPeliculas servicioPeliculas;
//	@Autowired
//	ServicioComentarios servicioComentarios;

    public static void main(String[] args) {
        String command = "C:\\xampp\\xampp_start.exe";

        try {
            Process process = Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SpringApplication.run(PeliculonApplication.class, args);
    }
//	@Bean
//	CommandLineRunner ponPeliculas(){
//		return args -> {
//
//			Faker faker = new Faker(new Locale("es-ES"));
//			if(servicioPeliculas.findAll().size()<5) {
//				for (int i = 0; i < 5; i++) {
//					Pelicula p = new Pelicula();
//					p.setTitulo(faker.book().title());
//					p.setSinopsis(faker.chuckNorris().fact());
//					p.setFecha(LocalDate.now());
//					p.setNacionalidad(faker.country().countryCode2());
//					p.setImagen("pev.jpg");
//					p.setTrailer("https://www.youtube.com/embed/0c5wQ82JLy0?si=RdUj-JoEci8Pt9kH");
//					servicioPeliculas.save(p);
//
//					for (int j = 0; j < 3; j++) {
//						Comentario c = new Comentario();
//						c.setTitulo(faker.howIMetYourMother().character());
//						c.setContenido(faker.howIMetYourMother().quote());
//						c.setFecha(LocalDate.now());
//						c.setPelicula(p);
//
//						servicioComentarios.save(c);
//					}
//				}
//			}
//		};
//	}

    @Bean
    CommandLineRunner init(StorageService storageService){
        return (args) ->{
          storageService.init();
        };
    }


}
