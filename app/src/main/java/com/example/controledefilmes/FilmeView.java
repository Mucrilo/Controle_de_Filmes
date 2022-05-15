package com.example.controledefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class FilmeView extends AppCompatActivity {
    AppDatabase db;
    List<Filme> filmes;
    ListView listFilmes;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_view);
        db = AppDatabase.getDatabase(getApplicationContext());
        listFilmes = findViewById(R.id.list_Filme_View);
    }

    @Override
    protected void onResume(){
        super.onResume();
        intent = new Intent(this, FilmeForm.class);
        preencheFilmes();
    }

    private void preencheFilmes(){
        filmes = db.filmeDAO().getALL();
        ArrayAdapter<Filme> adapter = new ArrayAdapter<>(this,
            android.R.layout.simple_list_item_1,filmes);
        listFilmes.setAdapter(adapter);
        listFilmes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Filme filmeselecionado = filmes.get(position);
                intent.putExtra("filme_id", filmeselecionado.getIdFilme());
                startActivity(intent);
            }
        });
    }

    public void cadastrarFilme(View view){startActivity(intent);}

    public void voltar(View view){finish();}
}