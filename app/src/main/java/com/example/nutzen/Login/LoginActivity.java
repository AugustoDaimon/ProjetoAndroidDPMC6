package com.example.nutzen.Login;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.nutzen.PratosDoDia.TempViewPagerPrincipalActivity;
import com.example.nutzen.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_1);

        Button loginButton = (Button) findViewById(R.id.loginButton);
        TextView forgotPasswordButton = (TextView) findViewById(R.id.forgotPasswordButton);
        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Código para iniciar a activity RecuperarSenhaActivity
                Intent intent = new Intent(LoginActivity.this, RecuperarSenhaActivity.class);
                startActivity(intent);
            }
        });

        loginButton.setOnClickListener(view -> {
            Intent intent = new Intent(LoginActivity.this, TempViewPagerPrincipalActivity.class);
            startActivity(intent);
        });
    }
}
