from django.urls import path
from .views import CharacterList, CharacterDetail, MangaList, MangaDetail
urlpatterns = [
    path('characters/', CharacterList.as_view()),
    path('characters/<int:pk>/', CharacterDetail.as_view()),
    path('manga/', MangaList.as_view()),
    path('manga/<int:pk>/', MangaDetail.as_view())
]