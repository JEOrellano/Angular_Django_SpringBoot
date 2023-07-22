from ast import List, Tuple
from typing import Any
from django.db import models
from enum import Enum
from datetime import datetime

# Create your models here.
''' TABLAS '''
# Tabla Curso
class Curso(models.Model):
    descripcion = models.CharField(max_length=255,blank=True)
    fechaDeInicio = models.DateField(blank=True,default=datetime.now)
    fechaDeFin = models.DateField(blank=True,default=datetime.now)
    class Meta:
        db_table = "Curso"
        verbose_name = "Curso"
        verbose_name_plural = "Cursos"
    def __unicode_(self):
        return "{} {} {} {}".format(self.id,self.descripcion,self.fechaDeInicio,self.fechaDeFin)
    def __str__(self):
        return "{} {} {} {}".format(self.id,self.descripcion,self.fechaDeInicio,self.fechaDeFin)

# Tabla Estudiante
class Estudiante(models.Model):
    nombre = models.CharField(max_length=255,blank=True)
    apellido = models.CharField(max_length=255,blank=True)
    email = models.CharField(max_length=255,blank=True)
    dni = models.IntegerField(blank=True,default=1000000)
    fechaDeNacimiento = models.DateField(blank=True,default=datetime.now)
    class Meta:
        db_table = "Estudiante"
        verbose_name = "Estudiante"
        verbose_name_plural = "Estudiantes"
    def __unicode_(self):
        return "{} {} {} {} {}".format(self.id,self.nombre,self.apellido,self.email,self.dni,self.fechaDeNacimiento)
    def __str__(self):
        return "{} {} {} {} {}".format(self.id,self.nombre,self.apellido,self.email,self.dni,self.fechaDeNacimiento)

# Tabla Inscripcion
class Inscripcion(models.Model):
    '''ENUM'''
    ACEPTADA = "Aceptada"
    RECHAZADA = "Rechazada"
    PENDIENTE = "Pendiente"
    ESTADO = [
        (ACEPTADA, "Aceptada"),
        (RECHAZADA, "Rechazada"),
        (PENDIENTE, "Pendiente"),
    ]
    ##########
    fechaDeInscripcion = models.DateField(blank=True,default=datetime.now)
    estado = models.CharField(max_length=45,choices=ESTADO,blank=True,default=ACEPTADA)
    curso_id = models.ForeignKey(Curso,on_delete=models.CASCADE)
    estudiante_id = models.ForeignKey(Estudiante,on_delete=models.CASCADE)
    class Meta:
        db_table = "Inscripcion"
        verbose_name = "Inscripcion"
        verbose_name_plural = "Inscripciones"
    def __unicode_(self):
        return "{} {} {} {}".format(self.id,self.fechaDeInscripcion,self.estado,self.curso_id,self.estudiante_id)
    def __str__(self):
        return "{} {} {} {}".format(self.id,self.fechaDeInscripcion,self.estado,self.curso_id,self.estudiante_id)




