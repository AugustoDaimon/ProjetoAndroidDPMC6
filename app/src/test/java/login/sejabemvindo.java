package login;

public class sejabemvindo {

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

    public class LoginActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_login);

            Button buttonLogin = findViewById(R.id.buttonLogin);
            Button buttonForgotPassword = findViewById(R.id.buttonForgotPassword);
            Button buttonSignInWithGoogle = findViewById(R.id.buttonSignInWithGoogle);

            buttonLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica de login aqui
                }
            });

            buttonForgotPassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica para lidar com o clique no botão "Esqueci minha senha" aqui
                }
            });

            buttonSignInWithGoogle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Lógica para lidar com o clique no botão "Sign in with Google" aqui
                }
            });
        }
    }

}
