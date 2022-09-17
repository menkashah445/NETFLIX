package com.example.netflix.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflix.R;

public class StepThree extends AppCompatActivity {
    String plannane,plancost,plancostformat,UserEmailid,UserPassword;
    TextView Signout,textView;
    LinearLayout paymentlinearlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_step_three);
        getSupportActionBar ().hide ();
        paymentlinearlayout=findViewById(R.id.paymentlinearlayout);
        textView=findViewById(R.id.stepthree);
        Signout=findViewById(R.id.signoutstepthree);
        Intent i = getIntent ();
          plannane = i.getStringExtra ("planName");
          plancost = i.getStringExtra ("planCost");
          plancostformat = i.getStringExtra ("planCostFormat");
          UserEmailid =i.getStringExtra ("UserEmailId");
          UserPassword = i.getStringExtra ("UserPassword");


          Signout.setOnClickListener (new View.OnClickListener () {
              @Override
              public void onClick(View view) {
                  Intent i = new Intent (StepThree.this,SigninActivity.class);
                  startActivity (i);
              }
          });
        SpannableString str = new SpannableString ("Step 3 0f 3");
        StyleSpan boldspan = new StyleSpan (Typeface.BOLD);
        StyleSpan boldspan1 = new StyleSpan (Typeface.BOLD);
        str.setSpan (boldspan,5,6, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        str.setSpan (boldspan1,5,6,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                paymentlinearlayout.setOnClickListener (new View.OnClickListener () {
                    @Override
                    public void onClick(View view) {
                        Intent i = new Intent (StepThree.this,PaymentGateWay.class);
                        i.putExtra("PlanName",plannane);
                        i.putExtra("PlanCost",plancost);
                        i.putExtra("PlanCostFormat",plancostformat);
                        i.putExtra("EmailId",UserEmailid);
                        i.putExtra("Password",UserPassword);
                        startActivity(i);
                    }
                });



    }
}