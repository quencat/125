package com.example.test.cs125;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.EditText;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import com.google.gson.JsonObject;

import java.io.Serializable;
import java.util.Locale;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity implements Serializable{
    /** Request queue for our API requests. */
    private static RequestQueue requestQueue;

    private EditText write;



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
