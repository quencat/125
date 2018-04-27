package com.example.test.cs125;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity implements Serializable{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputEditText ed = findViewById(R.id.Input);

        final Button enter = findViewById(R.id.enter);
        enter.setText("Enter");
        enter.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                enter.setText("Clicked");
                String pass = ed.getText().toString();
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("key", pass);
                startActivity(i);
            }
        });
    }
}
