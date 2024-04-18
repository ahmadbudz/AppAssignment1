package com.example.projectapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText username = findViewById(R.id.editTextText);
        final EditText password = findViewById(R.id.editTextTextPassword);

        Button signUpButton = findViewById(R.id.button4);
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        Button loginButton = findViewById(R.id.button3);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                SharedPreferences preferences = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String userDetails = preferences.getString(user + pass + "data","Username or password is Incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("displayName",user);
                editor.commit();

                if (userDetails.equals("Username or password is Incorrect")) {
                    Toast.makeText(Login.this, "Username or password is incorrect", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(Login.this, Activities.class);
                    startActivity(intent);
                }
            }
        });

    }
}