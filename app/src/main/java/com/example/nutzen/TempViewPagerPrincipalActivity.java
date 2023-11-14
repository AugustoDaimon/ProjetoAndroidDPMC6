package com.example.nutzen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

/* TODO OBSERVACAO: CONTEM A LOGICA POR TRAS DAS TELAS DESLIZANTES NA TELA PRINCIPAL
    DEVENDO SER ANEXADA DENTRO DE UM OUTRO FRAGMENTO QUE SERA A TELA PRINCIPAL (O MESMO COM O XML)*/

public class TempViewPagerPrincipalActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp_view_pager_principal);

        ViewPager2 viewPager = findViewById(R.id.pager);

        PrincipalSlideAdapter adapter = new PrincipalSlideAdapter(getSupportFragmentManager(), getLifecycle());
        viewPager.setAdapter(adapter);
    }
}