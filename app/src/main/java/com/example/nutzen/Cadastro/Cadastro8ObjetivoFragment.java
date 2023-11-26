package com.example.nutzen.Cadastro;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.nutzen.MainActivity;
import com.example.nutzen.R;

public class Cadastro8ObjetivoFragment extends Fragment {

    private Button btnGanharMassa;
    private Button btnPerderMassa;

    public Cadastro8ObjetivoFragment() {
        // Required empty public constructor
    }

    public static Cadastro8ObjetivoFragment newInstance(String param1, String param2) {
        Cadastro8ObjetivoFragment fragment = new Cadastro8ObjetivoFragment();
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
        return inflater.inflate(R.layout.fragment_cadastro_8_objetivo, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        btnGanharMassa = (Button) getView().findViewById(R.id.btnGanharMassa);
        btnPerderMassa = (Button) getView().findViewById(R.id.btnPerderMassa);

        btnGanharMassa.setOnClickListener((v) -> {
            startActivity(new Intent(getActivity(), Cadastro9GanharActivity.class));
        });

        btnPerderMassa.setOnClickListener((v) -> {
            startActivity(new Intent(getActivity(), Cadastro9PerderActivity.class));
        });
    }
}