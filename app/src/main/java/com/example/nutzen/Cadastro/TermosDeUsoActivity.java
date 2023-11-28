package com.example.nutzen.Cadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.nutzen.Cadastro.Cadastro1NomeFragment;
import com.example.nutzen.Cadastro.CadastroActivity;
import com.example.nutzen.R;

public class TermosDeUsoActivity extends AppCompatActivity {
    ImageButton btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_termos_de_uso);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v ->{
            finish();
        });
    }
}