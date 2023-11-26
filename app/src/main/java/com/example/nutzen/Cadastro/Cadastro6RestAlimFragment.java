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
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

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

    public int getOpcaoRestricaoAlimentar() {
        try {
            selectedRadioButton = (RadioButton) getView().findViewById(radioGroup.getCheckedRadioButtonId());

            AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
            builderInputValidation.setTitle("Selecione uma das opções!!");
            builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });

            if(selectedRadioButton.getId() == -1) { // Se nenhuma opção for selecionada
                builderInputValidation.show();
            }else {
                if(selectedRadioButton.getId() == (R.id.radioButtonSim)){
                    return 1;
                }else{
                    if(selectedRadioButton.getId() == (R.id.radioButtonNao)){
                        return 0;
                    }
                }
            }

        }catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
            alertException.show();
        }
        return -1;
    }
}