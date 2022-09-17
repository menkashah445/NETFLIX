package com.example.netflix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.netflix.R;

public class ChooseYourPlan extends AppCompatActivity {
    TextView Signin;
    Button continuebutton;
    RadioButton radiobasic, radiostandard,radiopremium;
    String plannane,plancost,plancostformat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_choose_your_plan);
        getSupportActionBar ().hide ();
        Signin = findViewById (R.id.signinstepone);
        continuebutton = findViewById (R.id.continuebuttonchooseplan);
        radiobasic = findViewById (R.id.radiobuttonforbasic);
        radiopremium = findViewById (R.id.radiobuttonforpremium);
        radiostandard = findViewById (R.id.radiobuttonforstandard);


        radiobasic.setOnCheckedChangeListener (new Radio_check ());
//        radiobasic.setChecked (true);


        radiostandard.setOnCheckedChangeListener (new Radio_check ());
//        radiostandard.setChecked (true);

        radiopremium.setOnCheckedChangeListener (new Radio_check ());
            radiopremium.setChecked (true);



        continuebutton.setOnClickListener (view -> {
            Intent i = new Intent (ChooseYourPlan.this, FinishUpAccount.class);
            i.putExtra ("planName",plannane);
            i.putExtra ("planCost",plancost);
            i.putExtra ("planCostFormat",plancostformat);
            startActivity (i);

        });

        Signin.setOnClickListener (view -> {
            Intent i = new Intent (ChooseYourPlan.this, SigninActivity.class);
            startActivity (i);
        });


    }
         class Radio_check implements CompoundButton.OnCheckedChangeListener{


             @Override
             public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                 if(isChecked){
                     if(compoundButton.getId()==R.id.radiobuttonforbasic);
                     plannane ="basic";
                     plancost="349";
                     plancostformat="₹ 349/month";
                     radiostandard.setChecked (false);
                     radiopremium.setChecked (false);

                     if(compoundButton.getId ()==R.id.radiobuttonforstandard);
                     plannane="standard";
                     plancost="649";
                     plancostformat="₹ 699/month";
                     radiobasic.setChecked (false);
                     radiopremium.setChecked (false);

                     if(compoundButton.getId ()==R.id.radiobuttonforpremium);
                     plannane="premium";
                     plancost="749";
                     plancostformat="₹ 799/month";
                     radiobasic.setChecked (false);
                     radiostandard.setChecked (false);
                 }
             }
         }


    }

