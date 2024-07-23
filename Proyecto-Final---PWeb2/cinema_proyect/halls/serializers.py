from django.contrib.auth.models import User,Group
from rest_framework import serializers
from .models import Hall, Showtime, Seat

class HallSerializer(serializers.ModelSerializer):
    class Meta:
        model = Hall
        fields = '__all__'

class ShowtimeSerializer(serializers.ModelSerializer):
    available_seats = serializers.SerializerMethodField()

    class Meta:
        model = Showtime
        fields = ['id', 'movie', 'hall', 'show_date', 'show_time', 'end_time', 'available_seats']

    def get_available_seats(self, obj):
        return obj.get_available_seats()

class SeatSerializer(serializers.ModelSerializer):
    class Meta:
        model = Seat
        fields = '__all__'
