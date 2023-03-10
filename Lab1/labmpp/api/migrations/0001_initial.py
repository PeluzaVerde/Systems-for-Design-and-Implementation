# Generated by Django 4.1.7 on 2023-03-02 16:59

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Manga',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('mangaName', models.CharField(max_length=50, unique=True)),
            ],
        ),
        migrations.CreateModel(
            name='Characters',
            fields=[
                ('id', models.BigAutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('characterName', models.CharField(max_length=50)),
                ('date_added', models.DateField(auto_now_add=True)),
                ('character_origin', models.ForeignKey(on_delete=django.db.models.deletion.CASCADE, to='api.manga')),
            ],
        ),
    ]
