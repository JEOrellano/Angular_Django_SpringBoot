package com.example.demo.controller;

import com.example.demo.Service.EstudianteService;
import com.example.demo.dto.EstudianteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/estudiante")
public class EstudianteController {
    @Autowired
    private EstudianteService estudianteService;

    @PostMapping
    public EstudianteDTO save(@RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.saveEstudiante(estudianteDTO);
    }
    @GetMapping
    public List<EstudianteDTO> all(){
        return estudianteService.findAll();
    }
    @GetMapping("/{id}")
    public EstudianteDTO find(@PathVariable Long id){
        return estudianteService.find(id);
    }
    @GetMapping("/ide/{email}")
    public EstudianteDTO find(@PathVariable String email){
        return estudianteService.findEmail(email);
    }
    @PutMapping("/{id}")
    public EstudianteDTO update(@PathVariable Long id, @RequestBody EstudianteDTO estudianteDTO){
        return estudianteService.update(id,estudianteDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        estudianteService.delete(id);
    }
}
