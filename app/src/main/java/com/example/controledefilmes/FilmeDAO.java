package com.example.controledefilmes;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface FilmeDAO {
    @Query("SELECT * FROM Filme WHERE idFilme = :id LIMIT 1")
    Filme get(int id);

    @Query("SELECT * FROM Filme")
    List<Filme> getALL();

    @Insert
    void insertAll(Filme... filmes);

    @Update
    void update(Filme filme);

    @Delete
    void delete(Filme filme);
}
