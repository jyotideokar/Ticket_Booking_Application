package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText usernameEdit, passwordEdit;
    private TextView createText;
    private SharedPreferences sharedPreferences;
    private Button loginBttn;
    String user, password;
    String user1, password1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        passwordEdit = findViewById(R.id.passwordEdit);
        usernameEdit = findViewById(R.id.usernameEdit);
        createText = findViewById(R.id.createText);
        loginBttn = findViewById(R.id.loginBttn);
        sharedPreferences = getSharedPreferences("Demo", MODE_PRIVATE);
        user = sharedPreferences.getString("name", null);
        password = sharedPreferences.getString("lock", null);


        createText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateAccountActivity.class);
                startActivity(intent);
            }
        });
        loginBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                user1 = usernameEdit.getText().toString();
                password1 = passwordEdit.getText().toString();

                if (user1.equals(" ") && password1.equals(" ")) {
                    Toast.makeText(MainActivity.this,"Enter Username and Password",Toast.LENGTH_SHORT).show();

                } else
                    if (user1.equals(user) && password1.equals(password)){
                        Intent intent = new Intent(MainActivity.this, Content_List_Activity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        Toast.makeText(MainActivity.this, "Enter correct username and password", Toast.LENGTH_SHORT).show();
                    }


            }
        });


    }
}