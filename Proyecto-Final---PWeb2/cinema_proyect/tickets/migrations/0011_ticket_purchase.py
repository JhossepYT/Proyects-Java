# Generated by Django 5.0.6 on 2024-07-12 00:34

import django.db.models.deletion
from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('purchases', '0003_remove_purchase_tickets'),
        ('tickets', '0010_alter_ticket_price'),
    ]

    operations = [
        migrations.AddField(
            model_name='ticket',
            name='purchase',
            field=models.ForeignKey(blank=True, null=True, on_delete=django.db.models.deletion.CASCADE, related_name='tickets', to='purchases.purchase'),
        ),
    ]
