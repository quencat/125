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
import android.widget.Toast;

import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    TextToSpeech ttobj = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ImageButton play = findViewById(R.id.Play);
        final ImageButton save = findViewById(R.id.Save);
        final ImageButton share = findViewById(R.id.Share);
        final ImageButton Return = findViewById(R.id.Return);
        /*playbutton*/
        final String passed = getIntent().getExtras().getString("key","null");
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
                String toSpeak = passed;
                Toast.makeText(getApplicationContext(), toSpeak, Toast.LENGTH_SHORT).show();
                ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
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
