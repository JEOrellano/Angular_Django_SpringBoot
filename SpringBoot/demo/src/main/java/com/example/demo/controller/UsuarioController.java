package com.example.demo.controller;

import com.example.demo.Service.UsuarioService;
import com.example.demo.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200/")
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public UsuarioDTO save(@RequestBody UsuarioDTO usuarioDTO) { return usuarioService.saveUsuario(usuarioDTO); }
    @GetMapping
    public List<UsuarioDTO> all() { return usuarioService.findAll(); }
    @GetMapping("{id}")
    public UsuarioDTO find(@PathVariable Long id) { return usuarioService.find(id); }
    @PutMapping("{id}")
    public UsuarioDTO update(@PathVariable Long id,@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.update(id,usuarioDTO);
    }
    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) { usuarioService.delete(id); }
}
