from django.apps import AppConfig


class HallsConfig(AppConfig):
    default_auto_field = 'django.db.models.BigAutoField'
    name = 'halls'

    def ready(self):
        import halls.signals
