package com.example.nutzen.Cadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.nutzen.Cadastro.Cadastro8ObjetivoFragment;
import com.example.nutzen.R;
import com.example.nutzen.Usuarios.Usuario;

import java.util.Date;

public class CadastroActivity extends AppCompatActivity {

    // Variaveis Globais
    int fragmentosNaPilha = 1; // Indica qual fragmento que está sendo exibido e quantos fragmentos há na pilha


    // Declaração de Botão Continuar e SeekBar
    private ImageButton btnVoltar;
    private Button btnContinuar;
    private SeekBar skbProgressoCadastro;
    private int progressoCadastro = 0;

    // Declaração dos Fragmentos dos Forms de Cadastro
    private Cadastro1NomeFragment fragCadastro1;
    private Cadastro2EmailSenhaFragment fragCadastro2;
    private Cadastro3GeneroFragment fragCadastro3;
    private Cadastro4DataNascFragment fragCadastro4;
    private Cadastro5FisicoFragment fragCadastro5;
    private Cadastro6RestAlimFragment fragCadastro6;
    private Cadastro7RestAlim2Fragment fragCadastro7;
    private Cadastro8ObjetivoFragment fragCadastro8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        // Instancia Usuario
        Usuario novoUsuario = new Usuario();

        // Instanciando fragmentos
        fragCadastro1 = new Cadastro1NomeFragment();
        fragCadastro2 = new Cadastro2EmailSenhaFragment();
        fragCadastro3 = new Cadastro3GeneroFragment();
        fragCadastro4 = new Cadastro4DataNascFragment();
        fragCadastro5 = new Cadastro5FisicoFragment();
        fragCadastro6 = new Cadastro6RestAlimFragment();
        fragCadastro7 = new Cadastro7RestAlim2Fragment();
        fragCadastro8 = new Cadastro8ObjetivoFragment();

        // Criação do FragmentManager e Adição do fragmento inicial ao Fragment Container View
        FragmentManager frag_manager = getSupportFragmentManager();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentContainerViewFormCadastro, fragCadastro1, "fragCadastro1").addToBackStack("fragCadastro1").commit();

        // Instancia SeekBar
        skbProgressoCadastro = (SeekBar) findViewById(R.id.SeekBar_ProgCadastro);
        skbProgressoCadastro.setMax(100);

        // Botão Voltar: Remove o ultimo fragmento na pilha
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> {
            //
            if (fragmentosNaPilha > 1) {
                frag_manager.popBackStackImmediate();
                fragmentosNaPilha--;
            }
            // TODO: Se estiver vazia Voltar para main

            // Atualiza a SeekBar
            progressoCadastro =  fragmentosNaPilha * 100/9;
            skbProgressoCadastro.setProgress(progressoCadastro);
            skbProgressoCadastro.refreshDrawableState();

            if(fragmentosNaPilha == 7) { // Para voltar da Tela Objetivos
                btnContinuar.setVisibility(View.VISIBLE);
            }
        });

        // Botão Continuar: Coleta os dados inseridos e avança para o proximo fragmento
        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(view -> {
            // Verifica o Fragmento Atual
            // Caso esteja no Frag X, pegue os dados nele e vá para o Frag X+1
            switch (fragmentosNaPilha){
                case 1:
                    String nome = fragCadastro1.getCampoNome();
                    if(nome != null) { // Verifica se a validação foi aceita ou não
                        novoUsuario.setNome(nome);
                        loadFragment(fragCadastro2, "fragCadastro2");
                    }
                    break;
                case 2:
                    String email = fragCadastro2.getCampoEmail();
                    String senha = fragCadastro2.getCampoSenha();
                    if(email != null && senha != null) {
                        novoUsuario.setEmail(email);
                        novoUsuario.setSenha(senha); // TODO Salvar hash da senha
                        loadFragment(fragCadastro3, "fragCadastro3");
                    }
                    break;
                case 3:
                    char genero = fragCadastro3.getOpcaoGenero();
                    if(genero != 0) {
                        novoUsuario.setGenero(genero);
                        loadFragment(fragCadastro4, "fragCadastro4");
                    }
                    break;
                case 4:
                    Date dataNasc = fragCadastro4.getDataNascimento(); // Idade é calculada e validada
                    if(dataNasc != null) {
                        novoUsuario.setDataNasc(dataNasc);
                        loadFragment(fragCadastro5, "fragCadastro5");
                    }
                    break;
                case 5:
                    double altura = fragCadastro5.getCampoAltura();
                    double massa = fragCadastro5.getCampoMassa();
                    if(altura != 0 && massa != 0) {
                        novoUsuario.setAltura(massa);
                        novoUsuario.setPeso(altura);
                        loadFragment(fragCadastro6, "fragCadastro6");
                    }
                    break;
                case 6:
                    int codRestricoesAlimentares = fragCadastro6.getOpcaoRestricaoAlimentar();
                    if(codRestricoesAlimentares != -1){
                        if((codRestricoesAlimentares == 1)){
                            novoUsuario.setRestricoesAlimentares(true);
                            Toast alertException = Toast.makeText(CadastroActivity.this, "Não Implementado", Toast.LENGTH_LONG);
                            alertException.show();
                            //loadFragment(fragCadastro7, "fragCadastro7");
                        }else{
                            novoUsuario.setRestricoesAlimentares(false);
                            fragmentosNaPilha++; // Pula o fragCadastro7
                            loadFragment(fragCadastro8, "fragCadastro8");
                        }
                    }
                    break;
                case 7:
                    // TODO: pegar Array de Strings com Restricoes selecionadas e salvar
                    loadFragment(fragCadastro8, "fragCadastro8");
                    break;
                case 8:
                    btnContinuar.setVisibility(View.GONE);
                    // TODO: Se formos recomendar Objetivos com base no IMC -> Calcular Imc -> Recomendar (If else
                    break;
                default:
                    // Obs Não acho q é para ter default (Ver oq por aqui ou tirar)
                    // Obs Replace pro msm fragmento da erro
                    break;
            }
        });

        // Bloquear acesso da SeekBar ao User, sem mudar aparencia (Como ocorre com Enabled=false)
        skbProgressoCadastro.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }

    // Metodo para carregar fragmentos no Fragment Container View, substituindo o fragmento visivel por um novo
    public void loadFragment(Fragment fragment, String tag) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainerViewFormCadastro, fragment, tag)
                .addToBackStack(tag)
                .commit();
        fragmentosNaPilha++;

        // Atualiza a SeekBar
        progressoCadastro =  fragmentosNaPilha * 100/9;
        skbProgressoCadastro.setProgress(progressoCadastro);
        skbProgressoCadastro.refreshDrawableState();
    }
}