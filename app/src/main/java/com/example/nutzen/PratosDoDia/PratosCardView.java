package com.example.nutzen.PratosDoDia;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;

import com.example.nutzen.R;

// https://stackoverflow.com/questions/50370617/using-cardview-as-compound-view-base
// https://blogs.oregonstate.edu/workla/2021/11/04/creating-a-custom-view-in-android/
public class PratosCardView extends CardView implements Observer { // View derivada de CardView com Observer/Listener

    private ImageView imgPrato;
    private TextView txtNomePrato;
    private TextView txtCalorias;
    private ImageButton btnFavoritar;


    private Drawable urlImage;
    private String urlReceita;

    private String nomePrato;
    private int calorias;
    private boolean isFavorite;

    public PratosCardView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public PratosCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public PratosCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        inflate(getContext(), R.layout.pratos_cardview, this);

        // Pegar as views que vamos usar
        txtNomePrato = (TextView) findViewById(R.id.txtNomePrato);
        txtCalorias = (TextView) findViewById(R.id.txtCalorias);
        imgPrato = (ImageView) findViewById(R.id.imgPrato);
        btnFavoritar = (ImageButton) findViewById(R.id.btnFavoritar);


        if (attrs != null) {
            TypedArray atribArray = context.obtainStyledAttributes(attrs, R.styleable.PratosCardView); // Pega os atributos customizados

            // Pega os valores dos atributos customizados
            nomePrato = atribArray.getString(R.styleable.PratosCardView_nomePrato);
            urlImage = atribArray.getDrawable(R.styleable.PratosCardView_urlImage);
            calorias = atribArray.getInt(R.styleable.PratosCardView_calorias, 0);
            urlReceita = atribArray.getString(R.styleable.PratosCardView_urlReceita);

            // Reciclar o atribArray
            atribArray.recycle();

            // Preenche views com atributos
            txtNomePrato.setText(nomePrato);
            txtCalorias.setText(calorias + " KCAL");
            imgPrato.setImageDrawable(urlImage);
        }

        // Quando este cardView é clicado
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirLink(getContext(), urlReceita);
            }
        });
    }

    private void abrirLink(Context context, String url) {
        if (url != null && !url.isEmpty()) {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        }
    }

    @Override
    public void onChanged(Object o) {

    }

    public Drawable getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(Drawable urlImage) {
        this.urlImage = urlImage;
        invalidate(); // Força a view a se refazer (Caso mude a URL durante execução)
    }

    public String getNomePrato() {
        return nomePrato;
    }

    public void setNomePrato(String nomePrato) {
        this.nomePrato = nomePrato;
        invalidate();
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
        invalidate();
    }

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
        invalidate();
    }

    public String getUrlReceita() {
        return urlReceita;
    }

    public void setUrlReceita(String urlReceita) {
        this.urlReceita = urlReceita;
    }
}
