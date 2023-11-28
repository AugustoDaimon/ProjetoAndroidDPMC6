package com.example.nutzen.PerfilUser;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.nutzen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    public ProfileFragment() {
        // Required empty public constructor
    }

    public static ProfileFragment newInstance() {
        ProfileFragment fragment = new ProfileFragment();
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
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserProfile userProfile;
        userProfile = new UserProfile("John Doe", "175 cm", "70 kg", "Perder massa", 0); // 0 for male

        ImageView imageProfile = getView().findViewById(R.id.imageProfile);
        TextView textName = getView().findViewById(R.id.textName);
        TextView textDetails = getView().findViewById(R.id.textDetails);
        ListView listFavoriteDishes = getView().findViewById(R.id.listFavoriteDishes);

        /*
        imageProfile.setImageResource(userProfile.getGender() == 0 ? R.drawable.male_profile_image : R.drawable.female_profile_image);

        textName.setText(userProfile.getName());

        String details = "Altura: " + userProfile.getHeight() +
                "\nPeso: " + userProfile.getWeight() +
                "\nObjetivo: " + userProfile.getGoal();
        textDetails.setText(details);


         */

        List<String> favoriteDishes = new ArrayList<>(); // Feito com o proposito de testar a lista - Ainda não pega dos favoritados na tela de pratos
        favoriteDishes.add("Teste Prato 1");
        favoriteDishes.add("Teste Prato 2");
        favoriteDishes.add("Teste Prato 3");

        FavoriteDishesAdapter adapter = new FavoriteDishesAdapter(this.getContext(), favoriteDishes);
        listFavoriteDishes.setAdapter(adapter);
    }
}