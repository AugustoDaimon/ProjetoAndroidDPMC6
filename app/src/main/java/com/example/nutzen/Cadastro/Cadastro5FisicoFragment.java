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

import java.util.Calendar;

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

    public double getCampoAltura() {
        AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
        builderInputValidation.setTitle("Altura inválida!");
        builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        try {
            double altura = Double.parseDouble(campoAltura.getText().toString());

            if(altura < 30 || altura > 300) {
                builderInputValidation.show();
            }else {
                return altura;
            }

        }catch (NumberFormatException numEx){
            builderInputValidation.show();
            return 0;
        }
        catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
        }
        return 0;
    }
    public double getCampoMassa() {
        AlertDialog.Builder builderInputValidation = new AlertDialog.Builder(getActivity());
        builderInputValidation.setTitle("Massa inválida!");
        builderInputValidation.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        try {
            double massa = Double.parseDouble(campoMassa.getText().toString());

            if(massa < 15) {
                builderInputValidation.show();
            }else {
                return massa;
            }

        }catch (NumberFormatException numEx){
            builderInputValidation.show();
            return 0;
        }
        catch (Exception ex){
            Toast alertException = Toast.makeText(getContext(), ex.getMessage(), Toast.LENGTH_LONG);
            alertException.show();
        }
        return 0;
    }
}