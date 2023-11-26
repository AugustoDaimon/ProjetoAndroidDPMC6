package com.example.nutzen.PratosDoDia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.example.nutzen.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/* TODO OBSERVACAO: CONTEM A LOGICA POR TRAS DAS TELAS DESLIZANTES NA TELA PRINCIPAL
    DEVENDO SER ANEXADA DENTRO DE UM OUTRO FRAGMENTO QUE SERA A TELA PRINCIPAL (O MESMO COM O XML)*/

public class TempViewPagerPrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_view_pager_principal);

        // TODO NAO SEI DIREITO COMO: Quando o user entrar no app, ver as horas e abrir na aba certa

        Button buttonRight = findViewById(R.id.buttonRight);
        Button buttonLeft = findViewById(R.id.buttonLeft);
        TextView tituloRefeicao = findViewById(R.id.tituloRefeicao);
        ViewPager2 viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        PrincipalSlideAdapter adapter = new PrincipalSlideAdapter(getSupportFragmentManager(), getLifecycle());
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