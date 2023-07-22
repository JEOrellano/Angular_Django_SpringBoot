from django.urls import path, include
from rest_framework import routers

''' IMPORTAR VISTAS DE VIEWS '''
from AppArg40SB import views
''' IMPORTAR USER KANOX TOKEN '''
from .views import RegisterAPI,LoginAPI,ManagerUserView,EstudiantePorEmailView,InscripcionPorIdEstudianteView
from knox import views as kanox_views

router = routers.DefaultRouter()
router.register(r'curso',views.CursoViewSet)
router.register(r'estudiante',views.EstudianteViewSet)
router.register(r'inscripcion',views.InscripcionViewSet)
# ---
urlpatterns = [
    path('registro',RegisterAPI.as_view(),name='register'),
    path('profile',ManagerUserView.as_view(),name='profile'),
    path('login',LoginAPI.as_view(),name='login'),
    path('logout',kanox_views.LogoutView.as_view(),name='logout'),
    path('logoutall',kanox_views.LogoutAllView.as_view(),name='logoutall'),
    path('estudiante-email/<str:ide>',EstudiantePorEmailView.as_view(), name = 'estudiante_email'),
    path('inscripcion-estudiante/<int:ide>',InscripcionPorIdEstudianteView.as_view(), name = 'inscripcion_estudiante'),
    path('',include(router.urls)),
]