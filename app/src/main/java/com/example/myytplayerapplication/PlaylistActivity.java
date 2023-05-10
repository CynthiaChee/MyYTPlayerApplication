package com.example.myytplayerapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class PlaylistActivity extends AppCompatActivity {

    //Initializing variables
    ListView myPlaylist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        //Find view by ID
        myPlaylist = findViewById(R.id.playlistListView);

        Intent userIntent = getIntent();
        Integer userID = userIntent.getIntExtra("userID", 0);

        DatabaseHelper db = new DatabaseHelper(this);
        ArrayList<String> videoList = db.getUserVideos(userID);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, videoList);
        myPlaylist.setAdapter(adapter);

    }
}
