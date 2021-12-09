package com.example.project3frontend;
//import com.google.cloud.firestore.GeoPoint;

public class User {

    // Note these names need to MATCH the JSON keys
    // Or use @SerializedName("key_name") to convert dynamically
    private String username;
    private float rating;
    //private GeoPoint city;
    private boolean isFullfiller;
    private String email;
    private String password;
    public User(String email, String username, String password) {
        this.email = email;
        this.username = username;
        this.password = password;
    }
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setFullfiller(boolean fullfiller) {
        isFullfiller = fullfiller;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
