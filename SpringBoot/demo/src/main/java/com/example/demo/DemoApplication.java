package com.example.demo;

import com.example.demo.Service.InscripcionService;
import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	EstudianteRepository estudianteRepository;
	@Autowired
	InscripcionRepository inscripcionRepository;
	@Autowired
	InscripcionService inscripcionService;
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx){
		return args -> {
			System.out.println("Hola mundo!!!");
			/* CREAR Y CARGAR DATOS */
			/* CURSO */
			// Curso
			Curso curso = new Curso(null,"SpringBoot",LocalDate.of(2023,Month.JUNE,13),LocalDate.of(2023,Month.JULY,6));
			Curso curso2 = new Curso(null,"Curso B",LocalDate.of(2023,Month.JUNE,2),LocalDate.of(2023,Month.JULY,12));
			Curso curso3 = new Curso(null,"Curso C",LocalDate.of(2023,Month.JUNE,3),LocalDate.of(2023,Month.JULY,13));
			Curso curso4 = new Curso(null,"Curso D",LocalDate.of(2023,Month.JUNE,4),LocalDate.of(2023,Month.JULY,14));
			Curso curso5 = new Curso(null,"Curso E",LocalDate.of(2023,Month.JUNE,5),LocalDate.of(2023,Month.JULY,15));
			Curso curso6 = new Curso(null,"Curso F",LocalDate.of(2023,Month.JUNE,6),LocalDate.of(2023,Month.JULY,16));
			Curso curso7 = new Curso(null,"Curso G",LocalDate.of(2023,Month.JUNE,7),LocalDate.of(2023,Month.JULY,17));
			curso = cursoRepository.saveAndFlush(curso);
			curso2 = cursoRepository.saveAndFlush(curso2);
			curso3 = cursoRepository.saveAndFlush(curso3);
			curso4 = cursoRepository.saveAndFlush(curso4);
			curso5 = cursoRepository.saveAndFlush(curso5);
			curso6 = cursoRepository.saveAndFlush(curso6);
			curso7 = cursoRepository.saveAndFlush(curso7);
			/* ESTUDIANTE */
			// Estudiante
			Estudiante estudiante = new Estudiante(null,"Esteban Joselo","Orellano","mobilelegendsbang2020bang@gmail.com",12345678,LocalDate.of(1988,Month.AUGUST,8),Period.between(LocalDate.of(1988,Month.AUGUST,8),LocalDate.now()).getYears());
			Estudiante estudiante2 = new Estudiante(null,"Nombre 2","Apellido 2","Email2@gmail.com",22345678,LocalDate.of(2003,Month.FEBRUARY,2),Period.between(LocalDate.of(2003,Month.FEBRUARY,2),LocalDate.now()).getYears());
			Estudiante estudiante3 = new Estudiante(null,"Nombre 3","Apellido 3","Email3@gmail.com",32345678,LocalDate.of(2003,Month.MARCH,3),Period.between(LocalDate.of(2003,Month.MARCH,3),LocalDate.now()).getYears());
			Estudiante estudiante4 = new Estudiante(null,"Nombre 4","Apellido 4","Email4@gmail.com",42345678,LocalDate.of(2003,Month.APRIL,4),Period.between(LocalDate.of(2003,Month.APRIL,4),LocalDate.now()).getYears());
			Estudiante estudiante5 = new Estudiante(null,"Nombre 5","Apellido 5","Email5@gmail.com",52345678,LocalDate.of(2003,Month.MAY,5),Period.between(LocalDate.of(2003,Month.MAY,5),LocalDate.now()).getYears());
			Estudiante estudiante6 = new Estudiante(null,"Nombre 6","Apellido 6","Email6@gmail.com",62345678,LocalDate.of(2003,Month.JUNE,6),Period.between(LocalDate.of(2003,Month.JUNE,6),LocalDate.now()).getYears());
			Estudiante estudiante7 = new Estudiante(null,"Roberto 7","Romero","Romero@gmail.com",72345678,LocalDate.of(2003,Month.JULY,7),Period.between(LocalDate.of(2003,Month.JULY,7),LocalDate.now()).getYears());
			estudiante = estudianteRepository.saveAndFlush(estudiante);
			estudiante2 = estudianteRepository.saveAndFlush(estudiante2);
			estudiante3 = estudianteRepository.saveAndFlush(estudiante3);
			estudiante4 = estudianteRepository.saveAndFlush(estudiante4);
			estudiante5 = estudianteRepository.saveAndFlush(estudiante5);
			estudiante6 = estudianteRepository.saveAndFlush(estudiante6);
			estudiante7 = estudianteRepository.saveAndFlush(estudiante7);
			/* INSCRIPCION */
			// Inscripcion
			/*
			Inscripcion inscripcion = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Aceptada,curso,estudiante);
			Inscripcion inscripcion2 = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Pendiente,curso2,estudiante2);
			Inscripcion inscripcion3 = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Rechazada,curso3,estudiante3);
			Inscripcion inscripcion4 = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Aceptada,curso4,estudiante4);
			Inscripcion inscripcion5 = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Aceptada,curso5,estudiante5);
			Inscripcion inscripcion6 = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Aceptada,curso6,estudiante6);
			Inscripcion inscripcion7 = new Inscripcion(null, LocalDate.of(2023,Month.APRIL,27),Estado.Aceptada,curso7,estudiante7);
			inscripcion = inscripcionRepository.saveAndFlush(inscripcion);
			inscripcion2 = inscripcionRepository.saveAndFlush(inscripcion2);
			inscripcion3 = inscripcionRepository.saveAndFlush(inscripcion3);
			inscripcion4 = inscripcionRepository.saveAndFlush(inscripcion4);
			inscripcion5 = inscripcionRepository.saveAndFlush(inscripcion5);
			inscripcion6 = inscripcionRepository.saveAndFlush(inscripcion6);
			inscripcion7 = inscripcionRepository.saveAndFlush(inscripcion7);
			*/
			/*INSCRIPCION POR SERVICIO*/
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Aceptada,
					curso.getId(),
					estudiante.getId()
			);
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Pendiente,
					curso2.getId(),
					estudiante2.getId()
			);
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Rechazada,
					curso3.getId(),
					estudiante3.getId()
			);
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Aceptada,
					curso4.getId(),
					estudiante4.getId()
			);
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Aceptada,
					curso5.getId(),
					estudiante5.getId()
			);
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Aceptada,
					curso6.getId(),
					estudiante6.getId()
			);
			inscripcionService.Inscribir(
					LocalDate.of(2023,Month.APRIL,27),
					Estado.Aceptada,
					curso7.getId(),
					estudiante7.getId()
			);

			for (Curso element : cursoRepository.findCursoComienzoPost01_02_2020v1())
				System.out.print(" FECHA INICIO CURSO " + element.getId() + ": " + element.getFechaDeInicio() + "\n" );

			System.out.print("ESTUDIANTES PAGINADOS ORDENADOS POR DNI");
			for (Estudiante aux: estudianteRepository.findAll(PageRequest.of(0,2, Sort.by(Sort.Direction.DESC,"dni"))))
			{
				System.out.print("DNI estudiante " +aux.getId() + ": " + aux.getDni() + "\n");
			}
		};
	}
}
