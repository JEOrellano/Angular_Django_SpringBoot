package com.example.demo.repository;

import com.example.demo.domain.Estado;
import com.example.demo.domain.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface InscripcionRepository extends JpaRepository<Inscripcion,Long> {
    //JPQL
    //● Listar todas las inscripciones rechazadas o pendiente
    @Query("SELECT i FROM Inscripcion i WHERE estado = 'Pendiente' OR estado = 'Rechazada'")
    List<Inscripcion> findInscripcionPendienteOrRechazada();

    //PARAMETRO
    //● Listar todas las inscripciones en base a un parámetro de estado
    @Query("SELECT i FROM Inscripcion i WHERE estado = :estado")
    List<Inscripcion> findAllInscripcionByEstado(@Param("estado") Estado estado);

    //NATIVA
    //#1● Listar todas las inscripciones en base a un parámetro de estado utilizando consulta nativa
    @Query(value = "SELECT * FROM Inscripcion WHERE estado = :estado", nativeQuery = true)
    List<Inscripcion> findAllInscripcionByEstadoNativa(@Param("estado") Estado estado);

    //DERIVADA
    List<Inscripcion> findByestadoIs(Estado recha);
    List<Inscripcion> findByEstadoIsOrEstadoIs(Estado recha,Estado pend);
    //List<Inscripcion> findByestadoIn(List<Estado> estados);
    //List<Inscripcion> findByestadoIn(Collection<Estado> estados);
}
