package com.lampa.emotionrecognition.utils;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.lampa.emotionrecognition.EmotionSummary;
import com.lampa.emotionrecognition.MainActivity;
import com.lampa.emotionrecognition.R;

import java.util.Objects;

public class MusicService extends Service {

    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    public void onCreate(){
        Toast.makeText(this, "Service created", Toast.LENGTH_SHORT).show();



        mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);
    }
    public void onStart(Intent intent, int startId){

        Bundle extras = intent.getExtras();

        String emotion = extras.getString("emotion");
        Toast.makeText(this,"Service started", Toast.LENGTH_SHORT).show();

        if(Objects.equals(emotion, "happy")){

            mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music1);

        }
        else if(Objects.equals(emotion, "sad")){

            mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);


        }
        else if(Objects.equals(emotion, "angry")){

            mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);


        }
        else if(Objects.equals(emotion, "disgust")){

            mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);

        }
        else if(Objects.equals(emotion, "fear")){

            mMediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music2);


        }
        mMediaPlayer.start();

        //Toast.makeText(this,"Service started", Toast.LENGTH_SHORT).show();
        //mMediaPlayer.start();
    }
    public void onDestroy(){
        Toast.makeText(this,"Service stopped", Toast.LENGTH_SHORT).show();
        mMediaPlayer.stop();
    }
}
