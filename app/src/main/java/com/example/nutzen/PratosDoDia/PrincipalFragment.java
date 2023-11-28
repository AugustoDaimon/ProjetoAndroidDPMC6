package com.example.nutzen.PratosDoDia;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.nutzen.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrincipalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrincipalFragment extends Fragment {

    public PrincipalFragment() {
        // Required empty public constructor
    }

    public static PrincipalFragment newInstance(String param1, String param2) {
        PrincipalFragment fragment = new PrincipalFragment();
        Bundle args = new Bundle();
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
        return inflater.inflate(R.layout.fragment_principal, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        // TODO FUTURAMENTE: Quando o user entrar no app, ver as horas e abrir na aba certa

        ImageButton buttonRight = getView().findViewById(R.id.buttonRight); // TODO
        ImageButton buttonLeft = getView().findViewById(R.id.buttonLeft);   // Implementar? Ou não (Ver se compensa)

        TextView tituloRefeicao = getView().findViewById(R.id.tituloRefeicao);
        ViewPager2 viewPager = getView().findViewById(R.id.pager);
        TabLayout tabLayout = getView().findViewById(R.id.tab_layout);

        PrincipalSlideAdapter adapter = new PrincipalSlideAdapter(getActivity().getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // Configure your tabs here based on the position
                // For example:
                String[] tabTitles = {"Café da Manhã", "Almoço", "Janta"}; // Replace with your tab titles
                tab.setText(tabTitles[position]);
            }
        }).attach();

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                if(position == 0){
                    buttonRight.setVisibility(Button.INVISIBLE);
                    tituloRefeicao.setText("Café da Manhã");
                    buttonLeft.setVisibility(Button.VISIBLE);
                } else if (position == 1) {
                    buttonRight.setVisibility(Button.VISIBLE);
                    tituloRefeicao.setText("Almoço");
                    buttonLeft.setVisibility(Button.VISIBLE);
                } else {
                    buttonRight.setVisibility(Button.VISIBLE);
                    tituloRefeicao.setText("Jantar");
                    buttonLeft.setVisibility(Button.INVISIBLE);
                }
                Log.e("Selected_Page", String.valueOf(position));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });;

        tituloRefeicao.setText(tabLayout.getTabAt(viewPager.getCurrentItem()).getText());
    }
}