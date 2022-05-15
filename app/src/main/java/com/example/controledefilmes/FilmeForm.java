package com.example.controledefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteConstraintException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FilmeForm extends AppCompatActivity {
    private AppDatabase db;
    private EditText edtTitulo, edtAno, edtAvaliacao, edtTempo;
    //spinner
    private Button btnSalvar, btnExcluir;
    private int dbFilmeId;
    private Filme dbFilme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filme_form);
        db = AppDatabase.getDatabase(getApplicationContext());
        edtTitulo = findViewById(R.id.edt_Filme_Form_Titulo);
        edtAno = findViewById(R.id.edt_Filme_Form_Ano);
        edtAvaliacao = findViewById(R.id.edt_Filme_Form_Avaliacao);
        edtTempo = findViewById(R.id.edt_Filme_Form_Tempo);
        //spinner
        btnSalvar = findViewById(R.id.btn__Filme_Form_Salvar);
        btnExcluir = findViewById(R.id.btn__Filme_Form_Excluir);
        dbFilmeId = getIntent().getIntExtra("filme_id", -1);
    }

    protected void onResume(){
        super.onResume();
        if(dbFilmeId >= 0) {
            getFilme();
        } else {
            btnExcluir.setVisibility(View.GONE);
        }
    }

    private void getFilme(){
        dbFilme = db.filmeDAO().get(dbFilmeId);
        edtTitulo.setText(dbFilme.getTitulo());
        edtAno.setText(dbFilme.getAno());
        edtAvaliacao.setText(dbFilme.getAvaliacao());
        edtTempo.setText(dbFilme.getTempo());
        //spinner
    }

    public void salvarFilme(View view) {
        String titulo = edtTitulo.getText().toString();
        String anoText = edtAno.getText().toString();
        String avaliacaoText = edtAvaliacao.getText().toString();
        String tempo = edtTempo.getText().toString();
        int ano, avalicao;
        //spinner

        if (titulo.equals("") || anoText.equals("") || avaliacaoText.equals("") || tempo.equals("") /* spinner */) {
            Toast.makeText(this, "É necessario preencher todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        ano = Integer.parseInt(anoText);
        avalicao = Integer.parseInt(avaliacaoText);

        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setAno(ano);
        filme.setAvaliacao(avalicao);
        filme.setTempo(tempo);
        //spinner
        
        if (dbFilme != null){
            filme.setIdFilme(dbFilmeId);
            db.filmeDAO().update(filme);
            Toast.makeText(this, "Atualizado !!!", Toast.LENGTH_SHORT).show();
        } else {
            db.filmeDAO().insertAll(filme);
            Toast.makeText(this, "Inserido !!!", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
    
    public void excluirFilme(View view){
        new AlertDialog.Builder(this)
                .setTitle("Exclusão de Filme")
                .setMessage("Deseja excluir esse filme?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
                        
    }
    
    private void excluir(){
        try {
            db.filmeDAO().delete(dbFilme);
            Toast.makeText(this, "Excluído !!!", Toast.LENGTH_SHORT).show();
        } catch (SQLiteConstraintException e) {
            Toast.makeText(this, "Não foi possível excluir", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void voltar(View view) {finish();}
}