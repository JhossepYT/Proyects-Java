# Generated by Django 5.0.6 on 2024-07-11 22:22

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('halls', '0002_seat'),
    ]

    operations = [
        migrations.AlterField(
            model_name='hall',
            name='name',
            field=models.CharField(max_length=255, unique=True),
        ),
        migrations.AlterField(
            model_name='seat',
            name='id',
            field=models.IntegerField(primary_key=True, serialize=False, unique=True),
        ),
    ]