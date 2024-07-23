"""
URL configuration for cinema_proyect project.

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/5.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""
from django.contrib import admin
from django.urls import include, path
from rest_framework import routers
from django.conf.urls.static import static
from django.conf import settings
from movies.views import MovieViewSet
from users.views import UserProfileViewSet
from halls.views import HallViewSet, ShowtimeViewSet, SeatViewSet
from tickets.views import TicketViewSet
from purchases.views import PurchaseViewSet

router = routers.DefaultRouter()
router.register(r'user', UserProfileViewSet)
router.register(r'movie', MovieViewSet)
router.register(r'hall', HallViewSet)
router.register(r'showtime', ShowtimeViewSet)
router.register(r'seat', SeatViewSet)
router.register(r'ticket', TicketViewSet)
router.register(r'purchase', PurchaseViewSet)

urlpatterns = [
    path('admin/', admin.site.urls),
    path('', include(router.urls)),
    path('api-auth/', include('rest_framework.urls', namespace='rest_framework'))
]

if settings.DEBUG:
    urlpatterns += static(settings.MEDIA_URL, document_root=settings.MEDIA_ROOT)
    urlpatterns += static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
