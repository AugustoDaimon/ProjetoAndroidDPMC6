package com.example.nutzen.Cadastro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nutzen.R;

public class Cadastro9GanharActivity extends AppCompatActivity {

    Button btnContinuar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_9_ganhar);

        btnContinuar = findViewById(R.id.btn_continuar);
        btnContinuar.setOnClickListener((view -> {
            startActivity(new Intent(Cadastro9GanharActivity.this, Cadastro9PerderActivity.class));
        }));
    }
}