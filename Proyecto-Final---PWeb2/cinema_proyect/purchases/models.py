from django.db import models
from django.contrib.auth.models import User
from tickets.models import Ticket


# Create your models here.
class Purchase(models.Model):
    id = models.AutoField(primary_key=True)
    user = models.ForeignKey(User, on_delete=models.CASCADE)
    purchase_date = models.DateTimeField(auto_now_add=True)
    total_amount = models.DecimalField(max_digits=10, decimal_places=2, default=0)

    def __str__(self):
        return f"Purchase {self.id} by {self.user.username}"
