package com.example.nutzen.Cadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.nutzen.MainActivity;
import com.example.nutzen.R;

public class CadastroActivity extends AppCompatActivity {

    // Variaveis Globais
    int fragmentosNaPilha = 1; // TODO: Verificar se é a implementaçao correta de manipular ordem dos Fragmentos (Ta funcionando, mas parece gambiarra)

    // Declaração de Botão Continuar e SeekBar
    private ImageButton btnVoltar;
    private Button btnContinuar;

    // Declaração dos Fragmentos dos Forms de Cadastro
    Cadastro1NomeFragment fragCadastro1;
    private Cadastro2EmailSenhaFragment fragCadastro2;
    private Cadastro3GeneroFragment fragCadastro3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        fragCadastro1 = new Cadastro1NomeFragment();
        fragCadastro2 = new Cadastro2EmailSenhaFragment();
        fragCadastro3 = new Cadastro3GeneroFragment();

        FragmentManager frag_manager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerViewFormCadastro, fragCadastro1, "fragCadastro1").addToBackStack("fragCadastro1").commit();

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> { // Perguntar pro Professor se pode criar ClickListener desse jeito reduzido
            if (fragmentosNaPilha > 1) {
                frag_manager.popBackStackImmediate(); // TODO: Corrigir! Perde os dados escritos nos TextEdit ao voltor
                fragmentosNaPilha--;
            }
            // TODO: Se estiver vazia Voltar para main
        });

        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(view -> {
            switch (fragmentosNaPilha){
                case 1:
                    loadFragment(fragCadastro2, "fragCadastro2");
                    break;
                case 2:
                    loadFragment(fragCadastro3, "fragCadastro3");
                    break;
                // Futuros Fragmentos
                default:
                    // Obs Replace pro msm fragmento da erro
                    break;
            }
        });
    }

    public void loadFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerViewFormCadastro, fragment, tag)
                .addToBackStack(tag)
                .commit();
        fragmentosNaPilha++;
    }
}