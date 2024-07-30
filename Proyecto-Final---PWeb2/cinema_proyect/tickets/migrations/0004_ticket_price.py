# Generated by Django 5.0.6 on 2024-07-07 04:33

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('tickets', '0003_alter_ticket_id'),
    ]

    operations = [
        migrations.AddField(
            model_name='ticket',
            name='price',
            field=models.DecimalField(decimal_places=2, default=0, max_digits=3),
            preserve_default=False,
        ),
    ]