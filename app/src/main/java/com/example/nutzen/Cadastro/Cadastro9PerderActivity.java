package com.example.nutzen.Cadastro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.nutzen.HomeActivity;
import com.example.nutzen.R;

public class Cadastro9PerderActivity extends AppCompatActivity {

    Button btnContinuar;
    TextView txtTermos;
    CheckBox checkTermos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_9_perder);

        checkTermos = findViewById(R.id.CheckBoxtermosDeUso);
        AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(Cadastro9PerderActivity.this);
        builderInputValidation.setTitle("Aceite os termos de uso para continuar!");
        builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        btnContinuar = findViewById(R.id.btn_continuar);
        btnContinuar.setOnClickListener((view -> {
            startActivity(new Intent(Cadastro9PerderActivity.this, HomeActivity.class));
            if(checkTermos.isChecked())
                startActivity(new Intent(Cadastro9PerderActivity.this, HomeActivity.class));
            else{
                builderInputValidation.show();
            }
        }));

        txtTermos = findViewById(R.id.txtTermosDeUSo);
        txtTermos.setOnClickListener((v -> {
            startActivity(new Intent(Cadastro9PerderActivity.this, TermosDeUsoActivity.class));
        }));
    }
}