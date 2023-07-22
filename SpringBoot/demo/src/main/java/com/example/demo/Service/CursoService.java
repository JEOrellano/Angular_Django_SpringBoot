package com.example.demo.Service;

import com.example.demo.domain.Curso;
import com.example.demo.dto.CursoDTO;
import com.example.demo.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoService {
    @Autowired
    private CursoRepository cursoRepository;
    public CursoDTO saveCurso(CursoDTO cursoDTO){
        Curso curso = new Curso(
                null,
                cursoDTO.getDescripcion(),
                cursoDTO.getFechaDeInicio(),
                cursoDTO.getFechaDeFin()
        );
        cursoRepository.save(curso);
        return cursoDTO;
    }
    public List<CursoDTO> findAll(){
        return cursoRepository.findAll()
                .stream().map(c -> new CursoDTO(c.getId(),c.getDescripcion(),c.getFechaDeInicio(),c.getFechaDeFin()))
                .collect(Collectors.toList());
    }
    public CursoDTO find(Long id){
        Curso curso = cursoRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("El id del curso no es valido"));
        return new CursoDTO(curso.getId(), curso.getDescripcion(),curso.getFechaDeInicio(),curso.getFechaDeFin());
    }
    public CursoDTO update(Long id,CursoDTO cursoDTO){
        Curso curso = new Curso(id,cursoDTO.getDescripcion(),cursoDTO.getFechaDeInicio(),cursoDTO.getFechaDeFin());
        cursoRepository.save(curso);
        return  cursoDTO;
    }
    public void delete(Long id) { cursoRepository.deleteById(id); }
}
