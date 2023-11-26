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
 * Use the {@link Cadastro1NomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro1NomeFragment extends Fragment {

    EditText campoNome;

    public Cadastro1NomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment cadastro_1_nome.
     */

    public static Cadastro1NomeFragment newInstance(String param1, String param2) {
        Cadastro1NomeFragment fragment = new Cadastro1NomeFragment();
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
        return inflater.inflate(R.layout.fragment_cadastro_1_nome, container, false);
    }

    // Quando a view é criada, associar campoNome com sua respectiva View
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        campoNome = (EditText) getView().findViewById(R.id.txtCampoNome);
    }

    // Metodo usado por CadastroActivity para pegar o valor do texto no campo de nome
    public String getCampoNome() {
        try {
            AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
            builderInputValidation.setTitle("Nome de Usúario Inválido!");
            builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    //campoNome.setText("");
                }
            });

            if(!campoNome.getText().toString().toUpperCase().matches("[A-Z]*")){
                builderInputValidation.setMessage("O nome de usúario deve conter apenas letras.");
                builderInputValidation.show();
            }else{
                if(campoNome.length() <= 4){
                    builderInputValidation.setMessage("O nome de usúario deve ter mais de quatro letras.");
                    builderInputValidation.show();
                }else{
                    return campoNome.getText().toString();
                }
            }
        }catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
            alertException.show();
        }
        return null;
    }
}