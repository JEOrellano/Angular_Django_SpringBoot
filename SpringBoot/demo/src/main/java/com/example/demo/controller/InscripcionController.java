package com.example.demo.controller;

import com.example.demo.Service.InscripcionService;
import com.example.demo.dto.InscripcionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/inscripcion")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;
    @PostMapping
    public InscripcionDTO save(@RequestBody InscripcionDTO inscripcionDTO){
        return inscripcionService.saveInscripcion(inscripcionDTO);
    }
    @GetMapping
    public List<InscripcionDTO> all(){
        return inscripcionService.findAll();
    }
    @GetMapping("{id}")
    public InscripcionDTO find(@PathVariable Long id){
        return inscripcionService.find(id);
    }
    @PutMapping("{id}")
    public InscripcionDTO update(@PathVariable Long id, @RequestBody InscripcionDTO inscripcionDTO){
        return inscripcionService.update(id,inscripcionDTO);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        inscripcionService.delete(id);
    }
}
