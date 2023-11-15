package com.example.nutzen.Cadastro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.nutzen.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cadastro3GeneroFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro3GeneroFragment extends Fragment {

    private RadioGroup radioGroup;
    private RadioButton selectedRadioButton;

    public Cadastro3GeneroFragment() {
        // Required empty public constructor
    }

    public static Cadastro3GeneroFragment newInstance(String param1, String param2) {
        Cadastro3GeneroFragment fragment = new Cadastro3GeneroFragment();
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
        return inflater.inflate(R.layout.fragment_cadastro_3_genero, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        radioGroup = (RadioGroup) getView().findViewById(R.id.radioGroup);
        selectedRadioButton = (RadioButton) getView().findViewById(radioGroup.getCheckedRadioButtonId());
    }

    public char getOpcaoGenero() {
        if(selectedRadioButton.getId() == (R.id.radioButtonFem)){
            return 'F';
        }else{
            if(selectedRadioButton.getId() == (R.id.radioButtonMasc)){
                return 'M';
            }else{
                // TODO: FAZER MENSAGEM PEDINDO PARA SELECIONAR UM!
                return 'M'; // TODO MUDAR ISSO TMB
            }
        }
    }
}