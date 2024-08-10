package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ContactSplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_contact_splash);

        TextView splashContact= findViewById(R.id.splashContact);

        Animation splashAnim= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slow_vision);

        splashContact.setAnimation(splashAnim);

        Intent intHome= new Intent(ContactSplash.this, MainActivity.class);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(intHome);
                finish();
            }
        },4000);
    }
}