from django.db import models
from django.contrib.auth.models import User

# Create your models here.

class UserProfile(models.Model):
    user = models.OneToOneField(User, on_delete=models.CASCADE)
    dni = models.CharField(max_length=8, unique=True)
    birthdate = models.DateField()
    phone = models.CharField(max_length=9)
    address = models.CharField(max_length=100)
    
    SOLTERO = 'Soltero(a)'
    CASADO = 'Casado(a)'
    DIVORCIADO = 'Divorciado(a)'
    VIUDO = 'Viudo(a)'

    CIVIL_STATUS_CHOICES = [
        (SOLTERO, 'Soltero(a)'),
        (CASADO, 'Casado(a)'),
        (DIVORCIADO, 'Divorciado(a)'),
        (VIUDO, 'Viudo(a)'),
    ]
    
    civil_status = models.CharField(max_length=20, choices=CIVIL_STATUS_CHOICES)

    def __str__(self):
        return self.user.username