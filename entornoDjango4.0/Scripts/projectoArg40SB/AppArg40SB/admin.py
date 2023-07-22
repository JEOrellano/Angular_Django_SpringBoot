from django.contrib import admin

# Register your models here.

'''TABLAS IMPORTACION'''
# Tabla Curso, Estudiante
from .models import Curso,Estudiante,Inscripcion

''' COLUMNAS TABLAS '''
# Tabla Curso, Estudiante, Inscripcion
class CursoAdmin(admin.ModelAdmin):
    list_display=('id','descripcion','fechaDeInicio','fechaDeFin')

class EstudianteAdmin(admin.ModelAdmin):
    list_display=('id','nombre','apellido','email','dni','fechaDeNacimiento')

class InscripcionAdmin(admin.ModelAdmin):
    list_display=('id','fechaDeInscripcion','estado','curso_id','estudiante_id')

'''TABLAS REGISTROS'''
# Tabla Curso, Estudiante, Inscripcion
admin.site.register(Curso,CursoAdmin)
admin.site.register(Estudiante,EstudianteAdmin)
admin.site.register(Inscripcion,InscripcionAdmin)
