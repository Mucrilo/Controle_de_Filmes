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

public class CategoriaForm extends AppCompatActivity {
    private  AppDatabase db;
    private EditText edtCategoria;
    private Button btnSalvar, btnExcluir;
    private int dbCategoriaId;
    private Categoria dbCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_form);
        db = AppDatabase.getDatabase(getApplicationContext());
        edtCategoria = findViewById(R.id.edt_Categoria_Form_Categoria);
        btnSalvar = findViewById(R.id.btn_Categoria_Form_Salvar);
        btnExcluir = findViewById(R.id.btn_Categoria_Form_Excluir);
        dbCategoriaId = getIntent().getIntExtra("usuario_id", -1);
    }

    protected void onResume(){
        super.onResume();
        if (dbCategoriaId >= 0) {
            getCategoria();
        } else {
            btnExcluir.setVisibility(View.GONE);
        }
    }

    private void getCategoria(){
        dbCategoria = db.categoriaDAO().get(dbCategoriaId);
        edtCategoria.setText(dbCategoria.getDescricao());
    }

    public void salvarCategoria(View view){
        String descricao = edtCategoria.getText().toString();

        if (descricao.equals("")){
            Toast.makeText(this, "É necessário preencher todos os campos !!!", Toast.LENGTH_SHORT).show();
            return;
        }

        Categoria categoria = new Categoria();
        categoria.setDescricao(descricao);

        if (dbCategoria != null){
            categoria.setIdCategoria(dbCategoriaId);
            db.categoriaDAO().update(categoria);
            Toast.makeText(this, "Atualizado !!!", Toast.LENGTH_SHORT).show();
        } else {
            db.categoriaDAO().insertAll(categoria);
            Toast.makeText(this, "Inserido !!!", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void excluirCategoria(View view) {
        new AlertDialog.Builder(this)
                .setTitle("Exclusão de Categoria")
                .setMessage("Deseja excluir esta categoria?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        excluir();
                    }
                })
                .setNegativeButton("Não", null)
                .show();
    }

    private void excluir() {
        try {
            db.categoriaDAO().delete(dbCategoria);
            Toast.makeText(this, "Excluído !!!", Toast.LENGTH_SHORT).show();
        } catch (SQLiteConstraintException e) {
            Toast.makeText(this, "Não foi possível excluir !!!", Toast.LENGTH_SHORT).show();
        }
        finish();
    }

    public void voltar(View view) {
        finish();
    }
}





























