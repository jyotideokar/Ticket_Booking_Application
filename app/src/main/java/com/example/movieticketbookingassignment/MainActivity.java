package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEdit, passwordEdit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordEdit = findViewById(R.id.passwordEdit);
        usernameEdit = findViewById(R.id.usernameEdit);


        SharedPreferences sharedPreferences = getSharedPreferences("demo",MODE_PRIVATE);





    }
}