from django.shortcuts import render
from django.shortcuts import render
from django.contrib.auth.models import User,Group
from rest_framework import viewsets
from .serializers import UserProfileSerializer
from .models import UserProfile

# Create your views here.

class UserProfileViewSet(viewsets.ModelViewSet):
    queryset = UserProfile.objects.all()
    serializer_class = UserProfileSerializer
