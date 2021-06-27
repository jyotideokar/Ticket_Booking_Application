package com.example.movieticketbookingassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateAccountActivity extends AppCompatActivity {
    private EditText usernameEdit, emailEdit, passwordEdit;
    private Button registerBttn;
    private SharedPreferences sharedPreferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);
        registerBttn = findViewById(R.id.registerBttn);
        usernameEdit = findViewById(R.id.usernameEdit);
        emailEdit = findViewById(R.id.emailEdit);
        passwordEdit = findViewById(R.id.passwordEdit);
        sharedPreferences = getSharedPreferences("Demo", MODE_PRIVATE);
        registerBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = usernameEdit.getText().toString();
                String email = emailEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if (user.isEmpty() || password.isEmpty() || email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please Fill All The Fields", Toast.LENGTH_SHORT).show();
                } else {

                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", user);
                    editor.putString("mail", email);
                    editor.putString("lock", password);
                    editor.apply();
                    Intent intent = new Intent(CreateAccountActivity.this,Content_List_Activity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });


    }
}