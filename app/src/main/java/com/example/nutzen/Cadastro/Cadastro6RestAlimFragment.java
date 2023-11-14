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
 * Use the {@link Cadastro6RestAlimFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro6RestAlimFragment extends Fragment {

    private RadioGroup radioGroup;
    private RadioButton selectedRadioButton;

    public Cadastro6RestAlimFragment() {
        // Required empty public constructor
    }

    public static Cadastro6RestAlimFragment newInstance(String param1, String param2) {
        Cadastro6RestAlimFragment fragment = new Cadastro6RestAlimFragment();
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
        return inflater.inflate(R.layout.fragment_cadastro_6_rest_alim, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        radioGroup = (RadioGroup) getView().findViewById(R.id.radioGroup);
        selectedRadioButton = (RadioButton) getView().findViewById(radioGroup.getCheckedRadioButtonId());
    }

    public boolean getOpcaoRestricaoAlimentar() {
        if(selectedRadioButton.getId() == (R.id.radioButtonSim)){
            return true;
        }else{
            if(selectedRadioButton.getId() == (R.id.radioButtonNao)){
                return false;
            }else{
                // TODO: FAZER MENSAGEM PEDINDO PARA SELECIONAR AO MENOS UM!
                return false; // TODO MUDAR ISSO TMB
            }
        }
    }
}