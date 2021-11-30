package com.example.project3frontend;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;

public class LandingActivity extends AppCompatActivity {
//    private void rotateOpen (){
//        AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim);
//    }
//    private void rotateClose (){
//        AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim);
//    }
//    private void fromBottom (){
//        AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim);
//    }
//    private void toBottom (){
//        AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim);
//    }
    private static final String TAG = "LandingActivity";
    private boolean clicked = false;
    private FloatingActionButton floatingActionButton;
    private FloatingActionButton floatingActionButton2;
    private FloatingActionButton floatingActionButton3;
    private TextView textName;
    private TextView textAbout;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton2 = findViewById(R.id.floatingActionButton2);
        floatingActionButton3 = findViewById(R.id.floatingActionButton3);
        textName = findViewById(R.id.textName);
        textAbout = findViewById(R.id.textAbout);
        IntentFactory factory = new IntentFactory();

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onAddButtonClicked();
            }
        });
        floatingActionButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(LandingActivity.this, NewRequestActivity.class);
                startActivity(intent);
            }
        });
        floatingActionButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = factory.getIntent(LandingActivity.this, OpenProjectsActivity.class);
                startActivity(intent);
            }
        });

    }

    private void onAddButtonClicked() {
        setVisibility(clicked);
        setAnimation(clicked);
        setClickable(clicked);
        clicked = !clicked;
    }
    private void setVisibility(Boolean clicked) {
        if(!clicked){
            floatingActionButton2.setVisibility(View.VISIBLE);
            floatingActionButton3.setVisibility(View.VISIBLE);
        }else{
            floatingActionButton2.setVisibility(View.INVISIBLE);
            floatingActionButton3.setVisibility(View.INVISIBLE);
        }
    }

    private void setAnimation(Boolean clicked) {
        if(!clicked){
            floatingActionButton2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim));
            floatingActionButton3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim));
            floatingActionButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim));
        }else{
            floatingActionButton2.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim));
            floatingActionButton3.startAnimation(AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim));
            floatingActionButton.startAnimation(AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim));
        }
    }

    private void setClickable(Boolean clicked){
        if(!clicked){
            floatingActionButton2.setClickable(true);
            floatingActionButton3.setClickable(true);
        }else{
            floatingActionButton2.setClickable(false);
            floatingActionButton3.setClickable(false);
        }
    }



}
