package com.example.nutzen.Cadastro;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutzen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cadastro2EmailSenhaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro2EmailSenhaFragment extends Fragment {

    private EditText campoEmail; // TODO: FAZER VALIDAÇÃO
    private EditText campoSenha; // TODO: CONTEUDO SENSIVEL! FAZER OCULTAÇÂO E TMB VALIDACAO


    public Cadastro2EmailSenhaFragment() {
        // Required empty public constructor
    }

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

    // Definição das Expressões Regulares (Regex) para validação de Email e Senha
    private static final String EMAIL_PATTERN =
                    "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$";

    // Metodo usado por CadastroActivity para pegar o valor do texto no campo de email e senha
    public String getCampoEmail() {
        try {
            AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
            builderInputValidation.setTitle("Email Inválido!");
            builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });

            if(!campoEmail.getText().toString().matches(EMAIL_PATTERN)){
                builderInputValidation.setMessage(campoEmail.getText().toString() + " não é um email válido.");
                builderInputValidation.show();
            }else{
                return campoEmail.getText().toString();
            }
        }catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
        }
        return null;
    }

    public String getCampoSenha() {
        try {
            AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
            builderInputValidation.setTitle("Senha Inválida!");
            builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });

            if(!campoSenha.getText().toString().matches(PASSWORD_PATTERN)){
                builderInputValidation.setMessage("Senha não é válida.\n" +
                                                  "Sua senha deve ser composta por no mínimo:\n" +
                                                  "- Oito caracteres;\n" +
                                                  "- Uma letra maiuscula;\n" +
                                                  "- Uma letra minuscula;\n" +
                                                  "- Um número.\n");
                builderInputValidation.show();
            }else{
                return campoSenha.getText().toString();
            }
        }catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
            alertException.show();
        }
        return null;
    }
}