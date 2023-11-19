package com.example.nutzen.CustomViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;

import com.example.nutzen.R;

// https://stackoverflow.com/questions/50370617/using-cardview-as-compound-view-base
// https://blogs.oregonstate.edu/workla/2021/11/04/creating-a-custom-view-in-android/
public class PratosCardView extends CardView implements Observer {
    public PratosCardView(@NonNull Context context) {
        super(context);
        init();
    }

    public PratosCardView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PratosCardView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        inflate(getContext(), R.layout.pratos_cardview, this);
    }

    @Override
    public void onChanged(Object o) {

    }
}
