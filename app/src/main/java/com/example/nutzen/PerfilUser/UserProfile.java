package com.example.nutzen.PerfilUser;

public class UserProfile {
    private String name;
    private String height;
    private String weight;
    private String goal;
    private int gender; // 0 para homi, 1 muie
    private List<String> favoriteDishes;



    public UserProfile(String name, String height, String weight, String goal, int gender) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.goal = goal;
        this.gender = gender;
        this.favoriteDishes = new ArrayList<>();
    }


}
