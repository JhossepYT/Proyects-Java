# Generated by Django 5.0.6 on 2024-07-12 05:43

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('purchases', '0004_alter_purchase_purchase_date'),
    ]

    operations = [
        migrations.AlterField(
            model_name='purchase',
            name='purchase_date',
            field=models.DateTimeField(auto_now_add=True),
        ),
    ]
