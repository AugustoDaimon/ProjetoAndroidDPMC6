package com.example.nutzen.Login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.nutzen.HomeActivity;
import com.example.nutzen.R;

public class LoginActivity extends AppCompatActivity {

    private static final String EMAIL_KEY = "saved_email";
    private static final String PASSWORD_KEY = "saved_password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_1);

        EditText edtEmail = findViewById(R.id.editTextEmail);
        EditText edtSenha = findViewById(R.id.editTextPassword);
        CheckBox checkGuardarDados = findViewById(R.id.checkGuardarDados);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        TextView forgotPasswordButton = (TextView) findViewById(R.id.forgotPasswordButton);

        // RECUPERACAO DO EMAIL E SENHA SALVO CASO EXISTA
        SharedPreferences sharedPreferences = LoginActivity.this.getPreferences(Context.MODE_PRIVATE);
        String emailSalvo = sharedPreferences.getString(EMAIL_KEY, "");
        String senhaSalva = sharedPreferences.getString(PASSWORD_KEY, "");

        if (edtEmail.getText().toString().isEmpty()) {
            edtEmail.setText(emailSalvo);
        }
        if (edtSenha.getText().toString().isEmpty()) {
            edtSenha.setText(senhaSalva);
        }

        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para iniciar a activity RecuperarSenhaActivity
                Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(view -> {
            // SEGUE ABAIXO CÓDIGO PARA DEIXAR SALVO O EMAIL E SENHA NO CELULAR
            // USANDO PERSISTENCIA DE DADOS

            if(checkGuardarDados.isChecked()) {
                 String email = edtEmail.getText().toString();
                 String senha = edtSenha.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(EMAIL_KEY, email);
                editor.putString(PASSWORD_KEY, senha);
                editor.apply(); // Salvamento Assincrono
            }

            // ENVIA PARA A HOMEPAGE
            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
            startActivity(intent);
        });


    }
}
