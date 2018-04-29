package com.example.test.cs125;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Random;

public class Main2Activity extends AppCompatActivity {
    TextToSpeech ttobj = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ImageButton play = findViewById(R.id.Play);
        final ImageButton Return = findViewById(R.id.Return);
        final TextView Words = findViewById(R.id.Words);
        /*playbutton*/
        final String passed = getIntent().getExtras().getString("key","null");
        Words.setText(passed);


        ttobj = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                ttobj.setLanguage(Locale.ENGLISH);

            }

        });
        Return.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                Toast.makeText(getApplicationContext(), "Another One!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Main2Activity.this, MainActivity.class));
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                final String[] list = passed.split(" ");
                final float[] tone = {0.1f, 2.2f, 0.3f, 4.4f, 0.5f, 6.6f, 0.7f, 8.8f, 0.9f, 11.0f};
                for (int i = 0; i < list.length; i++) {
                    /*Random pitch = new Random();
                    final float set = pitch.nextFloat();*/
                    float set = tone[i % tone.length];
                    ttobj.setPitch(set);
                    String toSpeak = list[i];
                    Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                    ttobj.speak(toSpeak, TextToSpeech.QUEUE_ADD, null);
                }
            }
        });
    }
    public void onPause(){
        if(ttobj !=null){
            ttobj.stop();
            ttobj.shutdown();
        }
        super.onPause();
    }
}
