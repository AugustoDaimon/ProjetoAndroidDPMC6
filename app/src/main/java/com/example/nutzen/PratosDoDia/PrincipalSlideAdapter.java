package com.example.nutzen.PratosDoDia;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.nutzen.R;

public class PrincipalSlideAdapter extends FragmentStateAdapter {
    private static final int NUM_TABS = 3;

    public PrincipalSlideAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new Principal15CafeScrollFragment();
            case 1:
                return new Principal16AlmocoScrollFragment();
            default:
                return new Principal17JantaScrollFragment();
        }
    }

    public static class Principal15CafeScrollFragment extends Fragment { // TODO ? Renomear para ..SlideFragment
        // https://developer.android.com/training/animation/screen-slide?hl=pt-br#pagetransformer
        // https://medium.com/busoft/how-to-use-viewpager2-with-tablayout-in-android-eaf5b810ef7c

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_principal_15_cafe_scroll, container, false);
            return view;
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }
    }

    public static class Principal16AlmocoScrollFragment extends Fragment { // TODO ? Renomear para ..SlideFragment
        // https://developer.android.com/training/animation/screen-slide?hl=pt-br#pagetransformer
        // https://medium.com/busoft/how-to-use-viewpager2-with-tablayout-in-android-eaf5b810ef7c

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_principal_16_almoco_scroll, container, false);
            return view;
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }
    }

    public static class Principal17JantaScrollFragment extends Fragment { // TODO ? Renomear para ..SlideFragment
        // https://developer.android.com/training/animation/screen-slide?hl=pt-br#pagetransformer
        // https://medium.com/busoft/how-to-use-viewpager2-with-tablayout-in-android-eaf5b810ef7c

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_principal_17_janta_scroll, container, false);
            return view;
        }
        @Override
        public void onDestroyView() {
            super.onDestroyView();
        }
    }
}