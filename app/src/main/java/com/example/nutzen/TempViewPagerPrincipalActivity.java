package com.example.nutzen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

/* TODO OBSERVACAO: CONTEM A LOGICA POR TRAS DAS TELAS DESLIZANTES NA TELA PRINCIPAL
    DEVENDO SER ANEXADA DENTRO DE UM OUTRO FRAGMENTO QUE SERA A TELA PRINCIPAL (O MESMO COM O XML)*/

public class TempViewPagerPrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_view_pager_principal);

        ViewPager2 viewPager = findViewById(R.id.pager);
        TabLayout tabLayout = findViewById(R.id.tab_layout);

        PrincipalSlideAdapter adapter = new PrincipalSlideAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                // Configure your tabs here based on the position
                // For example:
                String[] tabTitles = {"Tab 1", "Tab 2", "Tab 3"}; // Replace with your tab titles
                tab.setText(tabTitles[position]);
            }
        }).attach();
    }
}