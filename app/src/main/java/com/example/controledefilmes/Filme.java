package com.example.controledefilmes;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Filme {
    @PrimaryKey(autoGenerate = true)
    int idFilme;
    int idcategoria; // chave estrangeira
    String titulo;
    int ano;
    int avaliacao; // 0 - 100
    String tempo;

    public Filme() {
    }

    public Filme(int idFilme, int idcategoria, String titulo, int ano, int avaliacao, String tempo) {
        this.idFilme = idFilme;
        this.idcategoria = idcategoria;
        this.titulo = titulo;
        this.ano = ano;
        this.avaliacao = avaliacao;
        this.tempo = tempo;
    }

    public int getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(int idFilme) {
        this.idFilme = idFilme;
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "idFilme=" + idFilme +
                ", idcategoria=" + idcategoria +
                ", titulo='" + titulo + '\'' +
                ", ano=" + ano +
                ", avaliacao=" + avaliacao +
                ", tempo='" + tempo + '\'' +
                '}';
    }
}
