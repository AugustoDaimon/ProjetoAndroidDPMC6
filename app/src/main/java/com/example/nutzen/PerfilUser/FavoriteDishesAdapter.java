package com.example.nutzen.PerfilUser;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FavoriteDishesAdapter extends ArrayAdapter<String> {

    public FavoriteDishesAdapter(Context context, List<String> dishes) {
        super(context, 0, dishes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        }

        String dish = getItem(position);

        TextView textView = convertView.findViewById(android.R.id.text1);
        textView.setText(dish);

        return convertView;
    }
}
