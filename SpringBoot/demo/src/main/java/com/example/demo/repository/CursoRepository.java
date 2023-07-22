package com.example.demo.repository;

import com.example.demo.domain.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public interface CursoRepository extends JpaRepository<Curso,Long> {
    //JPQL
    //● Listar todos los cursos
    @Query("SELECT c FROM Curso c")
    List<Curso> findAllCurso();
    //● Listar todos los cursos que hayan empezado después de “01/02/2020”
    @Query("SELECT c FROM Curso c WHERE fechaDeInicio > DATE('2020-02-01')")
    List<Curso> findCursoComienzoPost01_02_2020v1();

    //PARAMETROS
    @Query("SELECT c FROM Curso c WHERE fechaDeInicio > :fecha")
    List<Curso> findCursoComienzoPost01_02_2020(@Param("fecha") LocalDate fecha);

    //DERIVADA
    //● Listar todos los cursos derivada
    List<Curso> findAll();
    //● Listar todos los cursos que hayan empezado después de “01/02/2020” derivada
    List<Curso> findByfechaDeInicioAfter(LocalDate fechaIni);
}
