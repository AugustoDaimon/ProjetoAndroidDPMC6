package com.example.nutzen.Cadastro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.nutzen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cadastro2EmailSenhaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro2EmailSenhaFragment extends Fragment {

    EditText campoEmail; // TODO: FAZER VALIDAÇÃO
    EditText campoSenha; // TODO: CONTEUDO SENSIVEL! FAZER OCULTAÇÂO E TMB VALIDACAO


    public Cadastro2EmailSenhaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Cadastro2EmailSenhaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Cadastro2EmailSenhaFragment newInstance(String param1, String param2) {
        Cadastro2EmailSenhaFragment fragment = new Cadastro2EmailSenhaFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastro_2_email_senha, container, false);
    }

    // Quando a view é criada, associar campoEmail e campoSenha com sua respectiva View
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        campoEmail = (EditText) getView().findViewById(R.id.txtCampoEmail);
        campoSenha = (EditText) getView().findViewById(R.id.txtCampoSenha);
    }

    // Metodo usado por CadastroActivity para pegar o valor do texto no campo de email e senha
    public String getCampoEmail() {
        return campoEmail.getText().toString();
    }

    public String getCampoSenha() {
        return campoSenha.getText().toString();
    }
}