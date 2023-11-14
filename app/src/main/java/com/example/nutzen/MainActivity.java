package com.example.nutzen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nutzen.Cadastro.Cadastro1NomeFragment;
import com.example.nutzen.Cadastro.CadastroActivity;

public class MainActivity extends AppCompatActivity {


    /*Button botao = (Button) findViewById(R.id.botao);

    botao.setBackgroundResource(R.color.Red);
    */

    Button btnCadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCadastrar = (Button) findViewById(R.id.BtnCadastrar);
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DEBUGING PRINCIPAL
                startActivity(new Intent(MainActivity.this, TempViewPagerPrincipalActivity.class));
                //startActivity(new Intent(MainActivity.this, CadastroActivity.class));
            }
        });
    }
}