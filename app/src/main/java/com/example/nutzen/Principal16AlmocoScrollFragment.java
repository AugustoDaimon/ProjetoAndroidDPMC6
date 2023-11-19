package com.example.nutzen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Principal16AlmocoScrollFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_principal_16_almoco_scroll, container, false);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}