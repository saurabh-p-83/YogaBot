package com.example.yogabot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.Locale;

public class virabhadrasana2_pose extends AppCompatActivity {
    private VideoView videoView;
    private AppCompatButton clock_time;
    private AppCompatButton Start_btn;
    private TextView textView3;
    private int totalTime = 60; // default timer value in seconds
    private CountDownTimer countDownTimer;
    private boolean isTimerRunning = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_virabhadrasana2_pose);
        videoView = findViewById(R.id.videoView1);
        Start_btn = findViewById(R.id.Start_btn);
        clock_time = findViewById(R.id.clock_btn);
        clock_time.setText("01:00");
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
            public void onClick(View v) {
                if (isTimerRunning) {
                    stopTimer();
                } else {
                    startTimer(totalTime * 1000);
                    videoView.start();
                }
            }
        });

        textView3 = findViewById(R.id.textView3);

        AppCompatButton increaseBtn = findViewById(R.id.increase_btn);
        increaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalTime += 10;
                updateTimerDisplay(totalTime);
            }
        });

        AppCompatButton decreaseBtn = findViewById(R.id.decrease_btn);
        decreaseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (totalTime > 10) {
                    totalTime -= 10;
                    updateTimerDisplay(totalTime);
                }
            }
        });
    }

    private void startTimer(long timeInMillis) {
        countDownTimer = new CountDownTimer(timeInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                isTimerRunning = true;
                long secondsLeft = millisUntilFinished / 1000;
                updateTimerDisplay(secondsLeft);
            }

            @Override
            public void onFinish() {
                isTimerRunning = false;
                updateTimerDisplay(0);
            }
        }.start();
        Start_btn.setText("STOP");
    }

    private void stopTimer() {
        countDownTimer.cancel();
        isTimerRunning = false;
        Start_btn.setText("START");
    }

    private void updateTimerDisplay(long secondsLeft) {
        int minutes = (int) (secondsLeft / 60);
        int seconds = (int) (secondsLeft % 60);
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        clock_time.setText(timeLeftFormatted);
    }
}