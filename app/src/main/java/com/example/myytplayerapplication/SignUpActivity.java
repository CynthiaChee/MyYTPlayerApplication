package com.example.myytplayerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUpActivity extends AppCompatActivity {

    //Initializing variables
    EditText fullnameSignup, usernameSignup, passwordSignup, confirmPasswordSignup;
    Button signupButton;
    ArrayList<User> UserList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Find view by ID
        fullnameSignup = findViewById(R.id.signupFullname);
        usernameSignup = findViewById(R.id.signupUsername);
        passwordSignup = findViewById(R.id.signupPassword);
        confirmPasswordSignup = findViewById(R.id.signupConfirmPassword);
        signupButton = findViewById(R.id.signupButton);

        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<String> playlist = new ArrayList();


        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullname = fullnameSignup.getText().toString();
                String username = usernameSignup.getText().toString();
                String password = passwordSignup.getText().toString();
                String confpassword = confirmPasswordSignup.getText().toString();

                //Check if password same as confirm password
                if(password.equals(confpassword))
                {
                    User newUser = new User(username, password, fullname, playlist);
                    UserList.add(newUser);
                    long result = db.insertUser(newUser);
                    if(result > 0)
                    {
                        Toast.makeText(getApplicationContext(), "Signup successful.", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
