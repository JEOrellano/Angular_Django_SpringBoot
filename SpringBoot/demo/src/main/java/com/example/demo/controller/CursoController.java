package com.example.demo.controller;

import com.example.demo.Service.CursoService;
import com.example.demo.dto.CursoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService cursoService;
    @PostMapping
    public CursoDTO save(@RequestBody CursoDTO cursoDTO){
        return cursoService.saveCurso(cursoDTO);
    }
    @GetMapping
    public List<CursoDTO> all(){
        return cursoService.findAll();
    }
    @GetMapping("{id}")
    public CursoDTO find(@PathVariable Long id){
        return cursoService.find(id);
    }
    @PutMapping("/{id}")
    public CursoDTO update(@PathVariable Long id,@RequestBody CursoDTO cursoDTO){
        return cursoService.update(id,cursoDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cursoService.delete(id);
    }
}
