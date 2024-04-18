package com.example.projectapplication;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Exercises extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);

        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);

        String[] answers1 = new String[] {
                "????",
                "(4x^4) - (5x^3)",
                "(20x^4) - (20x^3)",
                "(20x^5) - (20x^4)",
        };
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, answers1);
        spinner1.setAdapter(adapter1);

        String[] answers2 = new String[] {
                "????",
                "(6x^2) - 5",
                "(6x) - 5 - 2",
                "(6x) - 5",
        };
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, answers2);
        spinner2.setAdapter(adapter2);

        String[] answers3 = new String[] {
                "????",
                "( (1+x^2)1-x(2x) )/(1+x^2)^2",
                "( (1+x^2)1-x(2x) )/(1+x^2)",
                "( x )/(1+x^2)^2",
        };
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, answers3);
        spinner3.setAdapter(adapter3);

        Button check1 = findViewById(R.id.check1);
        check1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner1.getSelectedItem().toString().equals("(20x^4) - (20x^3)")){
                    spinner1.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Exercises.this, "Answer is Correct Good Job", Toast.LENGTH_LONG).show();
                }else{
                    spinner1.setBackgroundColor(Color.RED);
                    Toast.makeText(Exercises.this, "Answer is Incorrect :(", Toast.LENGTH_LONG).show();
                }
            }
        });

        Button check2 = findViewById(R.id.check2);
        check2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner2.getSelectedItem().toString().equals("(6x) - 5")){
                    spinner2.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Exercises.this, "Answer is Correct Good Job", Toast.LENGTH_LONG).show();
                }else{
                    spinner2.setBackgroundColor(Color.RED);
                    Toast.makeText(Exercises.this, "Answer is Incorrect :(", Toast.LENGTH_LONG).show();
                }
            }
        });


        Button check3 = findViewById(R.id.check3);
        check3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(spinner3.getSelectedItem().toString().equals("( (1+x^2)1-x(2x) )/(1+x^2)^2")){
                    spinner3.setBackgroundColor(Color.GREEN);
                    Toast.makeText(Exercises.this, "Answer is Correct Good Job", Toast.LENGTH_LONG).show();
                }else{
                    spinner3.setBackgroundColor(Color.RED);
                    Toast.makeText(Exercises.this, "Answer is Incorrect :(", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    protected void onPause() {//save user state on this page
        super.onPause();
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int spinner1Data = spinner1.getSelectedItemPosition();
        int spinner2Data = spinner2.getSelectedItemPosition();
        int spinner3Data = spinner3.getSelectedItemPosition();
        editor.putInt("spinner1Data",spinner1Data);
        editor.putInt("spinner2Data",spinner2Data);
        editor.putInt("spinner3Data",spinner3Data);
        editor.commit();
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Spinner spinner1 = findViewById(R.id.spinner1);
        Spinner spinner2 = findViewById(R.id.spinner2);
        Spinner spinner3 = findViewById(R.id.spinner3);
        SharedPreferences preferences = getSharedPreferences("MYPREFS",MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int spinner1Data = preferences.getInt("spinner1Data",0);
        int spinner2Data = preferences.getInt("spinner2Data",0);
        int spinner3Data = preferences.getInt("spinner3Data",0);

        spinner1.setSelection(spinner1Data);
        spinner2.setSelection(spinner2Data);
        spinner3.setSelection(spinner3Data);
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