from django.db import models
from django.core.exceptions import ValidationError
from django.contrib.auth.models import User
from halls.models import Showtime, Seat

# Create your models here.
class Ticket(models.Model):
    id = models.AutoField(primary_key=True)
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    purchase = models.ForeignKey('purchases.Purchase', related_name='tickets', on_delete=models.CASCADE)
    showtime = models.ForeignKey(Showtime, on_delete=models.CASCADE)
    seat = models.ForeignKey(Seat, on_delete=models.CASCADE)
    price = models.DecimalField(max_digits=4, decimal_places=2)

    def __str__(self):
        return f"N° {self.id} || {self.user.username} - {self.showtime.movie.title} at {self.showtime.hall.name} - {self.showtime.show_date} at {self.showtime.show_time} - Seat {self.seat.name}"
    
    def clean(self):
        # Validar que el asiento pertenezca a la sala del showtime
        if self.seat.hall != self.showtime.hall:
            raise ValidationError('El asiento seleccionado no pertenece a la sala del horario seleccionado.')
        
        if not self.seat.is_available:
            raise ValidationError('El asiento seleccionado no está disponible.')
        
        if self.purchase.user != self.user:
            raise ValidationError('El usuario de la compra no coincide con el usuario del ticket.')
        
        # Validar que el asiento no esté ocupado para este showtime
        existing_ticket = Ticket.objects.filter(showtime=self.showtime, seat=self.seat).exists()
        if existing_ticket:
            raise ValidationError('Este asiento ya está ocupado para esta función.')

    def save(self, *args, **kwargs):
        self.full_clean()  # Validar antes de guardar
        super().save(*args, **kwargs)
