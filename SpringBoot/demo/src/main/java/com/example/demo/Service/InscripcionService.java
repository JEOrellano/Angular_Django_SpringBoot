package com.example.demo.Service;

import com.example.demo.domain.Curso;
import com.example.demo.domain.Estado;
import com.example.demo.domain.Estudiante;
import com.example.demo.domain.Inscripcion;
import com.example.demo.dto.InscripcionDTO;
import com.example.demo.repository.CursoRepository;
import com.example.demo.repository.EstudianteRepository;
import com.example.demo.repository.InscripcionRepository;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscripcionService {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private EstudianteRepository estudianteRepository;
    @Autowired
    private InscripcionRepository inscripcionRepository;
    @Transactional
    public void Inscribir(@NotNull LocalDate fechaDeInscripcion, @NotNull Estado estado, @NotNull @Positive Long curso_id, @NotNull @Positive Long estudiante_id){
        /* busca curso por id */
        Curso curso = cursoRepository
                .findById(curso_id)
                .orElseThrow(()->new RuntimeException("El id del curso no es valido"));
        /* busca estudiante por id */
        Estudiante estudiante = estudianteRepository
                .findById(estudiante_id)
                .orElseThrow(()->new RuntimeException("El id del estudiante no es valido"));
        /*valida mayor edad estudiante*/
        if(!estudiante.esMayorEdad()){
            throw new RuntimeException("El estudiante es menor de edad...");
        }
        /*valida inscripcion fecha no mayor a inicio de curso*/
        if(fechaDeInscripcion.isAfter(curso.getFechaDeInicio())){
            throw new RuntimeException("Las fechas de inscripcion pasaron");
        }
        /*registrar inscripcion*/
        Inscripcion inscripcion = new Inscripcion(
                null,
                fechaDeInscripcion,
                estado,
                curso,
                estudiante
        );
        inscripcionRepository.save(inscripcion);
    }
    /*Servicio + Controller*/
    public InscripcionDTO saveInscripcion(InscripcionDTO inscripcionDTO){
        Curso curso = cursoRepository
                .findById(inscripcionDTO.getCurso_id())
                .orElseThrow(()->new RuntimeException("El id del curso no es valido"));
        Estudiante estudiante = estudianteRepository
                .findById(inscripcionDTO.getEstudiante_id())
                .orElseThrow(()->new RuntimeException("El id del estudiante no es valido"));


        Inscripcion inscripcion = new Inscripcion(
                null,
                inscripcionDTO.getFechaDeInscripcion(),
                inscripcionDTO.getEstado(),
                curso,
                estudiante
        );
        inscripcionRepository.save(inscripcion);
        return inscripcionDTO;
    }
    public List<InscripcionDTO> findAll(){
        return inscripcionRepository.findAll()
                .stream().map(c -> new InscripcionDTO(c.getId(),c.getFechaDeInscripcion(),c.getEstado(),c.getCurso().getId(),c.getEstudiante().getId()))
                .collect(Collectors.toList());
    }
    public InscripcionDTO find(Long id){
        Inscripcion inscripcion = inscripcionRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("El id de inscripcion no es valido"));
        return new InscripcionDTO(inscripcion.getId(),inscripcion.getFechaDeInscripcion(),inscripcion.getEstado(),inscripcion.getCurso().getId(),inscripcion.getEstudiante().getId());
    }
    public InscripcionDTO update(Long id,InscripcionDTO inscripcionDTO){
        Curso curso = cursoRepository
                .findById(inscripcionDTO.getCurso_id())
                .orElseThrow(()->new RuntimeException("El id del curso no es valido"));
        Estudiante estudiante = estudianteRepository
                .findById(inscripcionDTO.getEstudiante_id())
                .orElseThrow(()->new RuntimeException("El id del estudiante no es valido"));
        Inscripcion inscripcion = new Inscripcion(id,inscripcionDTO.getFechaDeInscripcion(),inscripcionDTO.getEstado(),curso,estudiante);
        inscripcionRepository.save(inscripcion);
        return  inscripcionDTO;
    }
    public void delete(Long id) { inscripcionRepository.deleteById(id); };
}
