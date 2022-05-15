package com.example.controledefilmes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CategoriaDAO {
    @Query("SELECT * FROM Categoria WHERE idCategoria = :id LIMIT 1")
    Categoria get(int id);

    @Query("SELECT * FROM Categoria")
    List<Categoria> getAll();

    @Insert
    void insertAll(Categoria... categorias);

    @Update
    void update(Categoria categoria);

    @Delete
    void  delete(Categoria categoria);
}
