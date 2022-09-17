package com.example.netflix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflix.R;
import com.example.netflix.Screen.MainScreen;

import java.util.Timer;
import java.util.TimerTask;

public class SigninActivity extends AppCompatActivity {
ProgressBar ProgressBar;
TextView signintextview,forgotpasswordtextview;
 Button signinbutton;
 static int duration = 500;
 static  int counter = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        getSupportActionBar().hide();
        ProgressBar = findViewById (R.id.progressbarsignin);
        signintextview = findViewById (R.id.netflixsignup);
        forgotpasswordtextview = findViewById (R.id.signup);
        signinbutton = findViewById (R.id.signinbutton);
        ProgressBar.setVisibility (View.GONE);

        signinbutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                ProgressBar.setVisibility (View.VISIBLE);
                Intent i = new Intent (SigninActivity.this, MainScreen.class);
                startActivity (i);
            }
        });
        signintextview.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                ProgressBar.setVisibility (View.VISIBLE);
                Intent i = new Intent (SigninActivity.this, SwipeActivity.class);
                startActivity (i);
            }
        });
        forgotpasswordtextview.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Toast.makeText (SigninActivity.this, "forgotpassword", Toast.LENGTH_SHORT).show ();
            }
        });
    }
    public void progress() {
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                ProgressBar.setProgress(counter);
                if (counter == 500) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }
}