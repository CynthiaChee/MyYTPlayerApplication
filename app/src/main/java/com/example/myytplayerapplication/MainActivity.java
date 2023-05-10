package com.example.myytplayerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Initializing variables
    EditText usernameEdit, passwordEdit;
    Button signupButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find view by ID
        usernameEdit = findViewById(R.id.loginUsername);
        passwordEdit = findViewById(R.id.loginPassword);
        signupButton = findViewById(R.id.gotoSignupButton);
        loginButton = findViewById(R.id.loginButton);
        DatabaseHelper db = new DatabaseHelper(this);

        //If signup button is clicked
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });

        //If login button is clicked
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = usernameEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                boolean getUser = db.fetchUser(username, password);
                int userID = db.getUserID(username);

                if(getUser)
                {
                    Toast.makeText(MainActivity.this, "Login successful.", Toast.LENGTH_SHORT).show();
                    Intent playerIntent = new Intent(MainActivity.this, PlayerMenuActivity.class);
                    playerIntent.putExtra("userID", userID);
                    startActivity(playerIntent);
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Login error.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
