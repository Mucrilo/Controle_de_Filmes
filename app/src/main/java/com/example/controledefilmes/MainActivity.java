package com.example.controledefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lista_Filmes(View view) {startActivity(new Intent(this, FilmeView.class));}

    public void lista_Categorias(View view) {startActivity(new Intent(this, CategoriaView.class));}
}