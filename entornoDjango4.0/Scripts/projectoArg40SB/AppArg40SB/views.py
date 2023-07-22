from django.shortcuts import render
# Model Serializer
from .models import Curso,Estudiante,Inscripcion
from .serializers import CursoSerializer,EstudianteSerializer,InscripcionSerializer
''' API REST FRAMEWORK CORS '''
from rest_framework import viewsets
# --- User
from rest_framework import generics,permissions
from .serializers import RegisterSerializer,UserSerializer
from rest_framework.response import Response
from knox.models import AuthToken
from knox.views import LoginView as KnoxLoginView
from rest_framework.authtoken.serializers import AuthTokenSerializer
from django.contrib.auth import login
from rest_framework.views import APIView

# Create your views here.
''' CRUD - ABML '''
# Tabla Curso
class CursoViewSet(viewsets.ModelViewSet):
    permission_classes = (permissions.IsAuthenticated,)
    queryset = Curso.objects.all()
    serializer_class = CursoSerializer


# Tabla Estudiante
class EstudianteViewSet(viewsets.ModelViewSet):
    permission_classes = (permissions.IsAdminUser,)
    queryset = Estudiante.objects.all()
    serializer_class = EstudianteSerializer

class EstudiantePorEmailView(APIView):
    permission_classes = (permissions.IsAuthenticated,)
    def get(self, request, ide = None):
        estudianteEmail = Estudiante.objects.filter(email = ide)
        serializer = EstudianteSerializer(estudianteEmail, many = True)
        return Response(serializer.data)
    

# Tabla Inscripcion
class InscripcionViewSet(viewsets.ModelViewSet):
    queryset = Inscripcion.objects.all()
    serializer_class = InscripcionSerializer

class InscripcionPorIdEstudianteView(APIView):
    permission_classes = (permissions.IsAuthenticated,)
    def get(self, request, ide = None):
        inscripcionEstudiante = Inscripcion.objects.filter(estudiante_id = ide)
        serializer = InscripcionSerializer(inscripcionEstudiante, many = True)
        return Response(serializer.data)

# ------------ API usuario token
class RegisterAPI(generics.GenericAPIView):
	serializer_class = RegisterSerializer

	def post(self,request,*args,**kwargs):
		serializer = self.get_serializer(data=request.data)
		serializer.is_valid(raise_exception=True)
		user= serializer.save()
		return Response({
		"user":UserSerializer(user, context=self.get_serializer_context()).data,
		"token":AuthToken.objects.create(user)[1]
		})
    
class LoginAPI(KnoxLoginView):
    permission_classes = (permissions.AllowAny,)

    def post(self,request,format=None):
        serializer = AuthTokenSerializer(data=request.data)
        serializer.is_valid(raise_exception=True)
        user = serializer.validated_data['user']
        login(request,user)
        return super(LoginAPI,self).post(request,format=None)
    
class ManagerUserView(generics.RetrieveUpdateAPIView):
    serializer_class = UserSerializer
    permission_classes = (permissions.IsAuthenticated,)

    def get_object(self):
        return self.request.user
    