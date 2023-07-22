package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class CursoDTO {
    private Long id;
    private String descripcion;
    private LocalDate fechaDeInicio;
    private LocalDate fechaDeFin;
}
