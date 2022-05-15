package com.example.controledefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class CategoriaView extends AppCompatActivity {
    AppDatabase db;
    List<Categoria> categorias;
    ListView listCategorias;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_view);
        db = AppDatabase.getDatabase(getApplicationContext());
        listCategorias = findViewById(R.id.list_Categoria_View);
    }

    @Override
    protected void onResume(){
        super.onResume();
        intent = new Intent(this, CategoriaView.class);
        preencheCategorias();
    }

    private void preencheCategorias(){
        categorias = db.categoriaDAO().getAll();
        ArrayAdapter<Categoria> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1,categorias);
        listCategorias.setAdapter(adapter);
        listCategorias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Categoria categoriaselecionada = categorias.get(position);
                intent.putExtra("categoria_id", categoriaselecionada.getIdCategoria());
                startActivity(intent);
            }
        });
    }

    public void cadastrarCategoria(View view){startActivity(intent);}

    public void voltar(View view){finish();}
}