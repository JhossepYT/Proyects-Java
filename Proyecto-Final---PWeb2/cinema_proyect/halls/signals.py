from django.db.models.signals import pre_save
from django.dispatch import receiver
from datetime import datetime, timedelta
from halls.models import Showtime
from django.core.exceptions import ValidationError

@receiver(pre_save, sender=Showtime)
def set_end_time(sender, instance, **kwargs):
    if instance.show_time and instance.movie.duration_mins:
        show_datetime = datetime.combine(instance.show_date, instance.show_time)
        duration_timedelta = timedelta(minutes=instance.movie.duration_mins)
        end_datetime = show_datetime + duration_timedelta
        instance.end_time = end_datetime.time()
