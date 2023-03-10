from rest_framework import serializers
from .models import Characters,Manga

class CharacterSerializer(serializers.ModelSerializer):
    class Meta:
        model = Characters
        fields = ('__all__')



class MangaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Manga
        fields = ('__all__')