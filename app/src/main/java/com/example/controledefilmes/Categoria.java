package com.example.controledefilmes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Categoria {
    @PrimaryKey(autoGenerate = true)
    int idCategoria;
    String descricao;

    public Categoria() {
    }

    public Categoria(int idCategoria, String descricao) {
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategorizar=" + idCategoria +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
