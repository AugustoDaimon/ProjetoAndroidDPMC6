package com.example.nutzen.Cadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.nutzen.Cadastro8ObjetivoFragment;
import com.example.nutzen.MainActivity;
import com.example.nutzen.R;
import com.example.nutzen.TempViewPagerPrincipalActivity;

public class CadastroActivity extends AppCompatActivity {

    // Variaveis Globais
    int fragmentosNaPilha = 1; // Indica qual fragmento que está sendo exibido e quantos fragmentos há na pilha


    // Declaração de Botão Continuar e SeekBar
    private ImageButton btnVoltar;
    private Button btnContinuar;


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

        // Botão Voltar: Remove o ultimo fragmento na pilha
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(view -> {
            if (fragmentosNaPilha > 1) {
                frag_manager.popBackStackImmediate(); // TODO IMPORTANTE : Perde os dados escritos nos TextEdit ao voltor
                fragmentosNaPilha--;
            }
            // TODO IMPORTANTE : Se estiver vazia Voltar para main
        });

        // Botão Continuar: Coleta os dados inseridos e avança para o proximo fragmento
        btnContinuar = findViewById(R.id.btnContinuar);
        btnContinuar.setOnClickListener(view -> {
            switch (fragmentosNaPilha){
                case 1: // Caso esteja no Frag 1, pegue os dados dele e vá para o Frag 2
                    novoUsuario.setNome(fragCadastro1.getCampoNome());
                    loadFragment(fragCadastro2, "fragCadastro2");
                    break;
                case 2:
                    novoUsuario.setEmail(fragCadastro2.getCampoEmail());
                    novoUsuario.setSenha(fragCadastro2.getCampoSenha()); // TODO? Ideal seria colocar um hash
                    loadFragment(fragCadastro3, "fragCadastro3");
                    break;
                case 3:
                    novoUsuario.setGenero(fragCadastro3.getOpcaoGenero());
                    loadFragment(fragCadastro4, "fragCadastro4");
                    break;
                case 4:
                    novoUsuario.setDataNasc(fragCadastro4.getDataNascimento());
                    // TODO? Get Idade
                    loadFragment(fragCadastro5, "fragCadastro5");
                    break;
                case 5:
                    novoUsuario.setAltura(fragCadastro5.getCampoAltura());
                    novoUsuario.setPeso(fragCadastro5.getCampoMassa());
                    loadFragment(fragCadastro6, "fragCadastro6");
                    break;
                case 6:
                    novoUsuario.setRestricoesAlimentares(fragCadastro6.getOpcaoRestricaoAlimentar());
                    loadFragment(fragCadastro7, "fragCadastro7");
                    break;
                case 7:
                    // TODO: pegar Array de Strings com Restricoes selecionadas
                    loadFragment(fragCadastro8, "fragCadastro8");
                    break;
                case 8:
                    // TODO Esse daqui é diferente pois não vai botar continuar (A não ser que transformemos buttons em Pseudo RadioButtons)
                    // TODO IMPORTANTE: Se formos recomendar Objetivos com base no IMC -> Calcular Imc -> Recomendar (If else
                    // TODO: Enviar para Tela 9 (Esqueci como que manda para outra activity dps faco)
                    break;
                default:
                    // Obs Não acho q é para ter default (Ver oq por aqui ou tirar)
                    // Obs Replace pro msm fragmento da erro
                    break;
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
    }
}