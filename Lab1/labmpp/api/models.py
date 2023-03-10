from django.db import models

# Create your models here.
class Manga(models.Model):
    mangaName = models.CharField(max_length=50, unique=True)

    def __str__(self):
        return self.mangaName


class Characters(models.Model):
    characterName = models.CharField(max_length=50)
    character_sex = models.CharField(max_length=10)
    date_added = models.DateField(auto_now_add=True)
    character_origin = models.ForeignKey(Manga, on_delete=models.CASCADE)
    character_age = models.IntegerField()
    character_status = models.CharField(max_length=50)


    def __str__(self):
        return self.characterName
