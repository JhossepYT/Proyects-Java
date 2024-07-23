from django.db import models
from movies.models import Movie
from django.core.exceptions import ValidationError

# Create your models here.
class Hall(models.Model):
    name = models.CharField(max_length=255, unique=True)
    capacity = models.IntegerField()
    is_available = models.BooleanField(default=True)

    def __str__(self):
        return self.name

class Showtime(models.Model):
    movie = models.ForeignKey(Movie, on_delete=models.CASCADE)
    hall = models.ForeignKey(Hall, on_delete=models.CASCADE)
    show_date = models.DateField()
    show_time = models.TimeField()
    end_time = models.TimeField(null=True, blank=True)

    def __str__(self):
        return f"{self.movie.title} at {self.hall.name} - {self.show_time}"
    
    def clean(self):
        # Validar que la sala este disponible
        if not self.hall.is_available:
            raise ValidationError('La sala seleccionada no está disponible.')
        
        # Validar que no exista otra función en este horario para esta sala
        existing_showtimes = Showtime.objects.filter(
            hall=self.hall,
            show_date=self.show_date
        ).exclude(pk=self.pk)  # Exclude current instance when editing
        
        for showtime in existing_showtimes:
            if self.end_time and self.show_time < showtime.end_time and self.end_time > showtime.show_time:
                raise ValidationError(f'La sala está ocupada entre {showtime.show_time} y {showtime.end_time}.')
            elif not self.end_time and self.show_time < showtime.end_time:
                raise ValidationError(f'La sala está ocupada entre {showtime.show_time} y {showtime.end_time}.')
    
    def save(self, *args, **kwargs):
        self.full_clean()  # Validar antes de guardar
        super().save(*args, **kwargs)

    def get_available_seats(self):
        from tickets.models import Ticket
        total_seats = self.hall.capacity
        reserved_seats = Ticket.objects.filter(showtime=self).count()
        return total_seats - reserved_seats
    
class Seat(models.Model):
    hall = models.ForeignKey(Hall, related_name='seats', on_delete=models.CASCADE)
    name = models.CharField(max_length=2)
    is_available = models.BooleanField(default=True)

    def __str__(self):
        return f"{self.hall.name} - {self.name}"
    
    def clean(self):
        # Validar que la sala no exceda su capacidad al asignar este asiento
        existing_seats = Seat.objects.filter(hall=self.hall, is_available=True)
        if len(existing_seats) >= self.hall.capacity:
            raise ValidationError(f'La sala {self.hall.name} ha alcanzado su capacidad máxima de asientos.')
        
    def save(self, *args, **kwargs):
        self.full_clean()  # Validar antes de guardar
        super().save(*args, **kwargs)
    
    class Meta:
        unique_together = [['hall', 'name']]