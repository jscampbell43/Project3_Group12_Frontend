package com.example.project3frontend;

public class User {

    // Note these names need to MATCH the JSON keys
    // Or use @SerializedName("key_name") to convert dynamically
    private int userId;
    private String userName;
    private String password;
    private float rating;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public float getRating() {
        return rating;
    }
}
