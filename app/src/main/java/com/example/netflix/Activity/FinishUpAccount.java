package com.example.netflix.Activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.netflix.R;

public class FinishUpAccount extends AppCompatActivity {
    String plannane,plancost,plancostformat;
    TextView textView,Signin;
    Button continuebutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish_account);
        getSupportActionBar().hide();
        Intent i= getIntent();
        plannane=i.getStringExtra("PlanName");
        plancost=i.getStringExtra("PlanCost");
        plancostformat=i.getStringExtra("PlanCostFormat");
        textView=findViewById(R.id.step1of3finish);
        continuebutton=findViewById(R.id.continuefinish);
        Signin=findViewById(R.id.signinstepone);
        Signin.setOnClickListener(view -> {
            Intent i1 =new Intent(FinishUpAccount.this, SigninActivity.class);
            startActivity(i1);
        });
        continuebutton.setOnClickListener(view -> {
            Intent i12 =new Intent(FinishUpAccount.this, StepTwo.class);
            i12.putExtra ("planName",plannane);
            i12.putExtra ("planCost",plancost);
            i12.putExtra ("planCostFormat",plancostformat);
            startActivity (i12);
        });
        SpannableString st=new SpannableString("STEP 2 OF 3");
        StyleSpan boldspan=new StyleSpan(Typeface.BOLD);
        StyleSpan boldspan1=new StyleSpan(Typeface.BOLD);
        st.setSpan(boldspan,5,6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        st.setSpan(boldspan1,10,11, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(st);

    }
}