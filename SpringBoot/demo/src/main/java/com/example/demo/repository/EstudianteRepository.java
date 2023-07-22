package com.example.demo.repository;

import com.example.demo.domain.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudianteRepository extends JpaRepository<Estudiante,Long> {
    ///JPQL
    //● Listar todos los estudiantes
    @Query("SELECT e FROM Estudiante e")
    List<Estudiante> findAllEstudiante();
    //● Listar todos los estudiantes que tengan un dni mayor a 20M
    // y que su apellido sea “Romero”
    @Query("SELECT e FROM Estudiante e WHERE dni > 20000000 AND apellido = 'Romero'")
    List<Estudiante> findEstudianteByDni20MAndApellidoRomero();

    //DERIVADA
    //● Listar todos los estudiantes
    List<Estudiante> findAll();
    //● Listar todos los estudiantes que tengan un dni mayor a 20M
    // y que su apellido sea “Romero”
    List<Estudiante> findBydniGreaterThan(int nd);
    List<Estudiante> findByapellidoIs(String apellido);
    List<Estudiante> findByapellidoContaining(String apellido);
    List<Estudiante> findByapellidoLike(String apellido);
    List<Estudiante> findByDniGreaterThanAndApellidoIs(int nd,String ap);
    //List<Estudiante> findBydniGreaterThanAndapellidoLike(int nd,String ap);
    //List<Estudiante> findBydniGreaterThanAndapellidoContaining(int nd,String ap);
    //List<Estudiante> findByapellidoIsAnddniGreaterThan(String ap,int nd);
    //List<Estudiante> findByapellidoLikeAnddniGreaterThan(String ap,int nd);
    //List<Estudiante> findByapellidoContainingAnddniGreaterThan(String ap,int nd);

    // Ltsado paginado
    /*● Listar todos los estudiantes de forma paginada y ordenada ascendente por DNI
    Probar las siguientes combinaciones:
            ○ pagina 1, tamaño 5
            ○ pagina 0, tamaño 2
    */
    //estudianteRepository.findAll(PageRequest.of(0,2,Sort.by(Sort.Direction.ASC,"dni")))
    Estudiante findByEmail(String email);
}
