package com.example.nutzen.Cadastro;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;

import com.example.nutzen.R;

import java.util.Calendar;
import java.util.Date;

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
        int dia = dataNascimento.getDayOfMonth();
        int mes = dataNascimento.getMonth();
        int ano = dataNascimento.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(ano, mes, dia);

        return calendar.getTime();
    }

    // TODO !!!!!
    public int getIdade(){
        return 0;
    }
}