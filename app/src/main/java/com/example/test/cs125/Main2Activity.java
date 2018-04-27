package com.example.test.cs125;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final ImageButton play = findViewById(R.id.Play);
        /* click listener*/
        final ImageButton save = findViewById(R.id.Save);
        final ImageButton share = findViewById(R.id.Share);
        final ImageButton Return = findViewById(R.id.Return);

    }
}
