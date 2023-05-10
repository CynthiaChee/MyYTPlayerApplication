package com.example.myytplayerapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerMenuActivity extends AppCompatActivity {

    //Initializing variables
    EditText linkInput;
    Button playButton, addToPlaylistButton, userPlaylistButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_menu);

        //Get user ID from previous activity
        Intent myIntent = getIntent();
        Integer userID = myIntent.getIntExtra("userID", 0);

        //Find view by ID
        linkInput = findViewById(R.id.enterLinkEditText);
        playButton = findViewById(R.id.playVideoButton);
        addToPlaylistButton = findViewById(R.id.addToPlaylistButton);
        userPlaylistButton = findViewById(R.id.myPlaylistButton);

        DatabaseHelper db = new DatabaseHelper(this);

        //If play button is clicked
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String videoLink = linkInput.getText().toString();
                Intent videoPlayerIntent = new Intent(getApplicationContext(), VideoPlayerActivity.class);
                videoPlayerIntent.putExtra("videoLink", videoLink);
                startActivity(videoPlayerIntent);
            }
        });

        //If add to playlist button is clicked
        addToPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String link = linkInput.getText().toString();
                db.insertVideo(userID, link);
            }
        });

        //If my playlist button is clicked
        userPlaylistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(), PlaylistActivity.class);
                intent.putExtra("userID", userID);
                startActivity(intent);
            }
        });
    }
}
