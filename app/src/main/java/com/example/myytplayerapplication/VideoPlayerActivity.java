package com.example.myytplayerapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

public class VideoPlayerActivity extends YouTubeBaseActivity {

    //Initializing variables
    YouTubePlayer.OnInitializedListener userOnInitializedListener;
    Button playButton;
    YouTubePlayerView youtubePlayerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        //Find view by ID
        playButton = findViewById(R.id.videoPlayButton);
        youtubePlayerView = findViewById(R.id.YTview);

        Intent linkIntent = getIntent();
        String link = linkIntent.getStringExtra("videoLink");
        String[] splitLink = link.split("=");

        userOnInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(splitLink[1]);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
            }
        };

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youtubePlayerView.initialize(YoutubeConfig.getApiKey(), userOnInitializedListener);
            }
        });


    }
}
