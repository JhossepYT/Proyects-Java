from django.contrib.auth.models import User,Group
from rest_framework import serializers
from .models import UserProfile

class UserProfileSerializer(serializers.ModelSerializer):
    class Meta:
        model = UserProfile
        fields = ('user', 'dni', 'birthdate', 'phone','address', 'civil_status')
