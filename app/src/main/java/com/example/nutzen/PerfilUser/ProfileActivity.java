package com.example.nutzen.PerfilUser;

import com.example.nutzen.PerfilUser.UserProfile;

public class ProfileActivity extends AppCompatActivity {

    private UserProfile userProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        userProfile = new UserProfile("John Doe", "175 cm", "70 kg", "Perder massa", 0); // 0 for male

        ImageView imageProfile = findViewById(R.id.imageProfile);
        TextView textName = findViewById(R.id.textName);
        TextView textDetails = findViewById(R.id.textDetails);
        ListView listFavoriteDishes = findViewById(R.id.listFavoriteDishes);

        imageProfile.setImageResource(userProfile.getGender() == 0 ? R.drawable.male_profile_image : R.drawable.female_profile_image);

        textName.setText(userProfile.getName());

        String details = "Altura: " + userProfile.getHeight() +
                "\nPeso: " + userProfile.getWeight() +
                "\nObjetivo: " + userProfile.getGoal();
        textDetails.setText(details);

        List<String> favoriteDishes = userProfile.getFavoriteDishes();
        FavoriteDishesAdapter adapter = new FavoriteDishesAdapter(this, favoriteDishes);
        listFavoriteDishes.setAdapter(adapter);
    }
}
