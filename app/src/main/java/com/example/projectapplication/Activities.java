package com.example.projectapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activities extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activities);
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        String welcomeUser = "hello " + preferences.getString("displayName","");

        TextView welcome = findViewById(R.id.welcomeTextView);
        welcome.setText(welcomeUser);


        Button learnBasicsButton = findViewById(R.id.learn);
        learnBasicsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activities.this, learnBasicsCalculus.class);
                startActivity(intent);
            }
        });

        Button excercisesButton = findViewById(R.id.exercises);
        excercisesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activities.this, Exercises.class);
                startActivity(intent);
            }
        });

        Button helpfulBooksButton = findViewById(R.id.books);
        helpfulBooksButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activities.this, HelpfullBooks.class);
                startActivity(intent);
            }
        });

        Button logoutButton = findViewById(R.id.logout);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putBoolean("isLoggedIn",false);
                editor.commit();
                Intent intent = new Intent(Activities.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStop(){
        super.onStop();
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean("isLoggedIn",true);
        editor.commit();
    }

}