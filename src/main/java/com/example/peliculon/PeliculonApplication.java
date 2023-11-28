package com.example.peliculon;

import com.example.peliculon.model.Comentario;
import com.example.peliculon.model.Pelicula;
import com.example.peliculon.service.ServicioComentarios;
import com.example.peliculon.service.ServicioPeliculas;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.time.LocalDate;
import java.util.Locale;

@SpringBootApplication
public class PeliculonApplication {

	@Autowired
	ServicioPeliculas servicioPelicula;
	@Autowired
	ServicioComentarios servicioComentarios;

	public static void main(String[] args) {
		SpringApplication.run(PeliculonApplication.class, args);
	}
	@Bean
	CommandLineRunner ponPeliculas(){
		return args -> {

			Faker faker = new Faker(new Locale("es-ES"));
			if(servicioPelicula.findAll().size()<5) {
				for (int i = 0; i < 5; i++) {
					Pelicula p = new Pelicula();
					p.setTitulo(faker.book().title());
					p.setSinopsis(faker.chuckNorris().fact());
					p.setFecha(LocalDate.now());
					p.setNacionalidad(faker.country().countryCode2());
					p.setImagen("pev.jpg");
					p.setTrailer("-xB9yLQQX64BnegK");
					servicioPelicula.save(p);

					for (int j = 0; j < 3; j++) {
						Comentario c = new Comentario();
						c.setTitulo(faker.howIMetYourMother().character());
						c.setContenido(faker.howIMetYourMother().quote());
						c.setFecha(LocalDate.now());
						c.setPelicula(p);

						servicioComentarios.save(c);
					}
				}
			}
		};
	}

}
