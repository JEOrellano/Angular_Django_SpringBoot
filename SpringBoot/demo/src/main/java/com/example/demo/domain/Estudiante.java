package com.example.demo.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

@Entity
@Table(name = "Estudiante")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "dni")
    private int dni;

    @Column(name = "fechaDeNacimiento")
    private LocalDate fechaDeNacimiento;

    @Transient
    private int edad;
    public int edad(){
        return Period.between(this.fechaDeNacimiento,LocalDate.now()).getYears();
    }
    public boolean esMayorEdad(){
        return this.edad() >= 18;
    }
}
