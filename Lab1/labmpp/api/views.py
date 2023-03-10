from django.shortcuts import render
from rest_framework import generics
from .models import Characters,Manga
from .serializers import CharacterSerializer,MangaSerializer

class CharacterList(generics.ListCreateAPIView):
    serializer_class = CharacterSerializer

    def get_queryset(self):
        queryset = Characters.objects.all()
        location = self.request.query_params.get('location')
        if location is not None:
            queryset = queryset.filter(character_origin=location)
        return queryset

class CharacterDetail(generics.RetrieveUpdateDestroyAPIView):
    serializer_class = CharacterSerializer
    queryset = Characters.objects.all()



class MangaList(generics.ListCreateAPIView):
    serializer_class = MangaSerializer
    queryset = Manga.objects.all()


class MangaDetail(generics.RetrieveUpdateDestroyAPIView):
    serializer_class = MangaSerializer
    queryset = Manga.objects.all()


# Create your views here.
