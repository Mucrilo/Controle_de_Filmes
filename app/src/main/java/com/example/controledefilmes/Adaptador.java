package com.example.controledefilmes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private final Context ctx;
    private ArrayList<Categoria> categorias;

    public Adaptador(Context ctx, ArrayList<Categoria> categorias) {
        this.ctx = ctx;
        this.categorias = categorias;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View cview, ViewGroup viewGroup) {



        return null;
    }
}

















