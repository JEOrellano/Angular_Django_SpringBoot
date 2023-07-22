package com.example.demo.Service;

import com.example.demo.domain.Usuario;
import com.example.demo.dto.UsuarioDTO;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Transactional
    public UsuarioDTO saveUsuario(UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(
                null,
                usuarioDTO.getUsername(),
                usuarioDTO.getEmail(),
                usuarioDTO.getPassword(),
                usuarioDTO.getIs_superuser(),
                usuarioDTO.getIs_staff(),
                usuarioDTO.getIs_activate()
        );
        usuarioRepository.save(usuario);
        return usuarioDTO;
    }
    @Transactional
    public List<UsuarioDTO> findAll(){
        return usuarioRepository.findAll()
                .stream().map(c -> new UsuarioDTO(c.getId(),c.getUsername(),c.getEmail(),c.getPassword(),c.getIs_superuser(),c.getIs_staff(),c.getIs_activate()))
                .collect(Collectors.toList());
    }
    @Transactional
    public UsuarioDTO find(Long id){
        Usuario usuario = usuarioRepository
                .findById(id)
                .orElseThrow(()->new RuntimeException("El id del usuario no es valido"));
        return new UsuarioDTO(usuario.getId(),usuario.getUsername(),usuario.getEmail(),usuario.getPassword(),usuario.getIs_superuser(),usuario.getIs_staff(),usuario.getIs_activate());
    }
    @Transactional
    public UsuarioDTO update(Long id, UsuarioDTO usuarioDTO){
        Usuario usuario = new Usuario(id,usuarioDTO.getUsername(),usuarioDTO.getEmail(),usuarioDTO.getPassword(),usuarioDTO.getIs_superuser(),usuarioDTO.getIs_staff(),usuarioDTO.getIs_activate());
        usuarioRepository.save(usuario);
        return usuarioDTO;
    }
    @Transactional
    public void delete(Long id){ usuarioRepository.deleteById(id); }
}
