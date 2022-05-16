package com.example.controledefilmes;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Filme.class, Categoria.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context){
        if(INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                AppDatabase.class,
                "ControleDeFilmes").allowMainThreadQueries().build();
        }
        return INSTANCE;
    }
    public abstract FilmeDAO filmeDAO();

    public abstract  CategoriaDAO categoriaDAO();
}
