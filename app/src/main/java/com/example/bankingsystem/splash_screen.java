package com.example.bankingsystem;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
public class splash_screen extends AppCompatActivity {

    private static int SPLASH_SCREEN = 5050;
    Animation topAnim, bottomAnim;
    ImageView image, bgImage, heading, creator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screeen);


        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.botton_animation);
        image = findViewById(R.id.photo1);
        bgImage = findViewById(R.id.backgroundimg);
        heading = findViewById(R.id.photo3);
        creator = findViewById(R.id.photo4);

        image.setAnimation(topAnim);
        heading.setAnimation(bottomAnim);
        creator.setAnimation(bottomAnim);
        bgImage.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);
        image.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        heading.animate().translationY(1600).setDuration(1000).setStartDelay(4000);
        creator.animate().translationY(1600).setDuration(1000).setStartDelay(4000);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(splash_screen.this, MainActivity.class));
                finish();
            }
        },SPLASH_SCREEN);

    }

}

