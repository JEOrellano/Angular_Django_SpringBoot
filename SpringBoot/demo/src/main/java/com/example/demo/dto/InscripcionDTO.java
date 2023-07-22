package com.example.demo.dto;

import com.example.demo.domain.Estado;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class InscripcionDTO {
    private Long id;
    private LocalDate fechaDeInscripcion;
    private Estado estado;
    private Long curso_id;
    private Long estudiante_id;
}
