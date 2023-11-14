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
 * Use the {@link Cadastro5FisicoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cadastro5FisicoFragment extends Fragment {

    private EditText campoAltura;
    private EditText campoMassa;

    public Cadastro5FisicoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cadastro5FisicoFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Cadastro5FisicoFragment newInstance(String param1, String param2) {
        Cadastro5FisicoFragment fragment = new Cadastro5FisicoFragment();
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
        return inflater.inflate(R.layout.fragment_cadastro_5_fisico, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        campoAltura = (EditText) getView().findViewById(R.id.et_altura);
        campoMassa = (EditText) getView().findViewById(R.id.et_massa);
    }

    // TODO: Verificar se é Double msm, se nao for throw um alert
    public double getCampoAltura() {
        return Double.parseDouble(campoAltura.getText().toString());
    }
    public double getCampoMassa() {
        return Double.parseDouble(campoMassa.getText().toString());
    }
}