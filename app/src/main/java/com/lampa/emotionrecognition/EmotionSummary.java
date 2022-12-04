package com.lampa.emotionrecognition;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.lampa.emotionrecognition.utils.MusicService;

import java.util.Objects;

public class EmotionSummary extends AppCompatActivity implements View.OnClickListener{

    private Intent serviceIntent;
    private String emotion = "";
    private Bitmap imageBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emotion_summary);

        TextView emotionText = findViewById(R.id.emotionText);
        TextView suggestDo = findViewById(R.id.suggestDoText);
        TextView suggestDont = findViewById(R.id.suggestDontText);
        ImageView img = findViewById(R.id.pictureImg);

        TextView do1 = findViewById(R.id.do1);
        TextView do2 = findViewById(R.id.do2);
        TextView do3 = findViewById(R.id.do3);

        TextView dont1 = findViewById(R.id.dont1);
        TextView dont2 = findViewById(R.id.dont2);
        TextView dont3 = findViewById(R.id.dont3);



        Button buttonStart = findViewById(R.id.playerBtn);
        Button buttonStop = findViewById(R.id.stopBtn);

        //Gets values from previous page
        Bundle extras = getIntent().getExtras();
        String myEtText;

        buttonStart.setOnClickListener(this);
        buttonStop.setOnClickListener(this);

        serviceIntent = new Intent(getApplicationContext(), MusicService.class);

        if (extras != null) {

            //Sets feeling text
            myEtText = "You are feeling: " + extras.getString("emotion") + "!";
            emotionText.setText(myEtText);
            img.setImageBitmap((Bitmap) extras.get("image"));
            imageBitmap = (Bitmap) extras.get("image");
            emotion = extras.getString("emotion");

            Log.e("opa", emotion);

            if(Objects.equals(emotion, "sad")){

                do1.setText("Find what does make you happy. (And laugh).");
                do2.setText("Reach out to family or friends");
                do3.setText("Spend time in nature");

                dont1.setText("Isolate yourself");
                dont2.setText("Drink alcohol");
                dont3.setText("Focus on the past");



            }
            else if(Objects.equals(emotion, "happy")){

                Log.e("opa", emotion);

                do1.setText("Get some food");
                do2.setText("b");
                do3.setText("c");

                dont1.setText("a");
                dont2.setText("b");
                dont3.setText("c");

            }
            else if(Objects.equals(emotion, "neutral")){

                Log.e("opa", emotion);

                do1.setText("a");
                do2.setText("b");
                do3.setText("c");

                dont1.setText("a");
                dont2.setText("b");
                dont3.setText("c");

            }
            else if(Objects.equals(emotion, "angry")){

                Log.e("opa", emotion);

                do1.setText("Take some deep breaths.");
                do2.setText("Use relaxation strategies (Mindfulness).");
                do3.setText("Understand wjy you are feeling angry.");

                dont1.setText("Resort to drugs and/or alcohol");
                dont2.setText("Drive");
                dont3.setText("Ruminate");

            }
            else if(Objects.equals(emotion, "fear")){

                Log.e("opa", emotion);

                do1.setText("Go the gym");
                do2.setText("Talk with people");
                do3.setText("Do not eat too much");

                dont1.setText("Drink alcohol");
                dont2.setText("Take a lot of caffeine");
                dont3.setText("c");

            }
            else if(Objects.equals(emotion, "surprise")){

                Log.e("opa", emotion);

                do1.setText("a");
                do2.setText("b");
                do3.setText("c");

                dont1.setText("a");
                dont2.setText("b");
                dont3.setText("c");

            }
            else if(Objects.equals(emotion, "disgust")){

                Log.e("opa", emotion);

                do1.setText("a");
                do2.setText("b");
                do3.setText("c");

                dont1.setText("a");
                dont2.setText("b");
                dont3.setText("c");

            }
            else if(Objects.equals(emotion, "neutral")){

                Log.e("opa", emotion);

                do1.setText("a");
                do2.setText("b");
                do3.setText("c");

                dont1.setText("a");
                dont2.setText("b");
                dont3.setText("c");

            }

        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.playerBtn:

                Intent i = new Intent(EmotionSummary.this, PlayerActivity.class);

                //adding values from this page to next page
                i.putExtra("emotion", emotion);
                i.putExtra("image", imageBitmap);
                //go to next page
                startActivity(i);
                break;
            case R.id.stopBtn:
                stopService(new Intent(getApplicationContext(), MusicService.class));
                break;
        }
    }

}