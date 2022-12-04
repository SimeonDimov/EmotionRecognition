package com.lampa.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.airbnb.lottie.LottieAnimationView;
import com.lampa.emotionrecognition.utils.MusicService;

public class PlayerActivity extends AppCompatActivity implements View.OnClickListener {

    private Intent serviceIntent;
    private Button goBackBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        

        Bundle extras = getIntent().getExtras();
        String emotion = extras.getString("emotion");

            serviceIntent = new Intent(getApplicationContext(), MusicService.class);

            serviceIntent.putExtra("emotion",emotion);

            startService(serviceIntent);

         //goBackBTN = findViewById(R.id.goBackBtn);
    }

    @Override
    public void onClick(View v) {

    }
}