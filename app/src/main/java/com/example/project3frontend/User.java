package com.example.project3frontend;

public class User {

    public String getUsername() {
        return username;
    }

    public float getRating() {
        return rating;
    }

    public boolean isFullfiller() {
        return isFullfiller;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    // Note these names need to MATCH the JSON keys
    // Or use @SerializedName("key_name") to convert dynamically
    private String username;
    private float rating;
    //private GeoPoint city;
    private boolean isFullfiller;
    private String email;
    private String password;
}
