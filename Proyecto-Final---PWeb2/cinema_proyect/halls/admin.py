from django.contrib import admin
from .models import Hall, Showtime, Seat

# Register your models here.
admin.site.register(Hall)
admin.site.register(Showtime)
admin.site.register(Seat)