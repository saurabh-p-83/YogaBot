package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class malasana_pose extends AppCompatActivity {
    private CountDownTimer countDownTimer;
    Button Start_btn, clock_time;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_malasana_pose);
        videoView = findViewById(R.id.videoView1);
        Start_btn = findViewById(R.id.Start_btn);
        clock_time = findViewById(R.id.clock_btn);
        String videopath = "android.resource://" + getPackageName() + "/" + R.raw.demovideo;
        Uri uri = Uri.parse(videopath);
        videoView.setVideoURI(uri);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        // sets the media player to the videoView
        mediaController.setMediaPlayer(videoView);
        // sets the media controller to the videoView
        videoView.setMediaController(mediaController);

        Start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (countDownTimer != null) {
                    // Stop the countdown timer if it's already running
                    countDownTimer.cancel();
                    countDownTimer = null;
                }
                else {
                    // Start the countdown timer if it's not already running
                    countDownTimer = new CountDownTimer(60000, 1000) {
                        @Override
                        public void onTick(long millisUntilFinished) {
                            // Update a TextView with the time remaining
                            int secondsRemaining = (int) millisUntilFinished / 1000;
                            clock_time.setText(String.format("%d seconds remaininng", secondsRemaining));
                            // starts the video
                            videoView.start();
                        }

                        @Override
                        public void onFinish() {
                            // Do something when the countdown is finished, like play a sound or show a message
                            clock_time.setText("Time's up!");
                        }
                    }.start();
                }
            }
        });

    }

}