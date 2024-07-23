from django.db.models.signals import post_save, post_delete
from django.dispatch import receiver
from purchases.models import Purchase
from .models import Ticket

@receiver(post_save, sender=Ticket)
@receiver(post_delete, sender=Ticket)
def update_purchase_total_amount(sender, instance, **kwargs):
    purchase = instance.purchase
    if purchase:
        tickets = purchase.tickets.all()
        total_amount = sum(ticket.price for ticket in tickets)
        purchase.total_amount = total_amount
        purchase.save()
