from django.db import models

# Create your models here.
class Movie(models.Model):
    title = models.CharField(max_length=100)
    director = models.CharField(max_length=100)
    duration_mins = models.PositiveIntegerField()
    release_date = models.DateField()

    DRAMA = 'Drama'
    COMEDIA = 'Comedia'
    ACCION = 'Acción'
    CIENCIA_FICCION = 'Ciencia ficción'
    ANIMACION = 'Animación'
    ROMANCE = 'Romance'
    TERROR = 'Terror'
    FANTASIA = 'Fantasía'
    CRIMEN = 'Crimen'
    DOCUMENTAL = 'Documental'
    MUSICAL = 'Musical'
    SUSPENSO = 'Suspenso'
    AVENTURA = 'Aventura'
    BIOGRAFIA = 'Biografía'
    HISTORIA = 'Historia'

    OTRO = 'Otro'

    GENRE_CHOICES = [
        (ACCION, 'Acción'),
        (ANIMACION, 'Animación'),
        (AVENTURA, 'Aventura'),
        (BIOGRAFIA, 'Biografía'),
        (CIENCIA_FICCION, 'Ciencia ficción'),
        (COMEDIA, 'Comedia'),
        (CRIMEN, 'Crimen'),
        (DOCUMENTAL, 'Documental'),
        (DRAMA, 'Drama'),
        (FANTASIA, 'Fantasía'),
        (HISTORIA, 'Historia'),
        (MUSICAL, 'Musical'),
        (ROMANCE, 'Romance'),
        (SUSPENSO, 'Suspenso'),
        (TERROR, 'Terror'),
        (OTRO, 'Otro'),
    ]

    genre = models.CharField(max_length=100, choices=GENRE_CHOICES)
    synopsis = models.TextField()
    is_premiere = models.BooleanField(default=False)
    poster = models.ImageField(upload_to='posters/')
    carousel_image = models.ImageField(upload_to='carousel/', null=True, blank=True)
    trailer = models.URLField(null=True, blank=True)

    def __str__(self):
        return self.title