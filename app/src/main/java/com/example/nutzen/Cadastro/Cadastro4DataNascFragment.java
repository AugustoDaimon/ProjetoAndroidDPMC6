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
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.nutzen.R;

import java.util.Calendar;
import java.util.Date;

import java.time.LocalDate;
import java.time.Period;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cadastro4DataNascFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro4DataNascFragment extends Fragment {

    private DatePicker dataNascimento;

    public Cadastro4DataNascFragment() {
        // Required empty public constructor
    }

    public static Cadastro4DataNascFragment newInstance(String param1, String param2) {
        Cadastro4DataNascFragment fragment = new Cadastro4DataNascFragment();
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
        return inflater.inflate(R.layout.fragment_cadastro_4_data_nasc, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        dataNascimento = (DatePicker) getView().findViewById(R.id.dataNascimento);
    }

    public Date getDataNascimento(){
        try {
            int dia = dataNascimento.getDayOfMonth();
            int mes = dataNascimento.getMonth();
            int ano = dataNascimento.getYear();

            Calendar calendar = Calendar.getInstance();
            calendar.set(ano, mes, dia);

            AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
            builderInputValidation.setTitle("Idade inválida!");
            builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                }
            });

            if(getIdade(ano, mes, dia) < 13) {
                builderInputValidation.setMessage("A idade minimina permitida é a partir de 13 anos.");
                builderInputValidation.show();
            }else {
                return calendar.getTime();
            }

        }catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
            alertException.show();
        }
        return null;
    }

    public int getIdade(int ano, int mes, int dia){
        return Period.between(
                LocalDate.of(ano, mes, dia),
                LocalDate.now()
        ).getYears();
    }
}