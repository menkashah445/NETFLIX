package com.example.netflix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.netflix.R;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Timer;
import java.util.TimerTask;

public class StepTwo extends AppCompatActivity {
    String plannane,plancost,plancostformat,UserEmailId,UserPassword;
    TextView textView,Signin;
    EditText emailiduser,userpassword;
    Button continuebutton;

    ProgressDialog progressDialog;
    int counter=0;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_step_two);
        getSupportActionBar().hide();
        Intent i= getIntent();
       plannane =i.getStringExtra("PlanName");
        plancost=i.getStringExtra("PlanCost");
       plancostformat =i.getStringExtra("PlanCostFormat");
        Signin=findViewById(R.id.signinstepone);
        emailiduser=findViewById(R.id.emailedittextsteptwo);
        userpassword=findViewById(R.id.passwordedittextsteptwo);
        progressBar=findViewById(R.id.progressbarsteptwo);
        progressBar.setVisibility(View.GONE);
        continuebutton=findViewById(R.id.continuesteptwo);
        textView=findViewById(R.id.step2of3);

        Signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(StepTwo.this, SigninActivity.class);
                startActivity(i);
            }
        });
        continuebutton.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                UserEmailId = emailiduser.getText().toString();
                UserPassword = userpassword.getText().toString();
                Intent  i = new Intent (StepTwo.this,StepThree.class);
                i.putExtra ("planeName",plannane);
                i.putExtra ("planCost",plancost);
                i.putExtra ("planCostFormat",plancostformat);
                i.putExtra ("UserEmailId",UserEmailId);
                i.putExtra ("Password",UserPassword);
                startActivity (i);
            }
        });
        SpannableString str = new SpannableString ("Step 2 of 3");
        StyleSpan boldSpan = new StyleSpan (Typeface.BOLD);
        StyleSpan boldSpan1 = new StyleSpan (Typeface.BOLD);
        str.setSpan (boldSpan,5,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan (boldSpan1,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

    }
    public void progress() {
        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
                progressBar.setProgress(counter);
                if (counter == 1000) {
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }
}