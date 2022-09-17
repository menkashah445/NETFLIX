package com.example.netflix.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.netflix.R;
import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class PaymentGateWay extends AppCompatActivity  implements PaymentResultListener{
    String planname,plancost,plancostformat,UserEmailid,UserPassword,Userid;
EditText firstnameedittext, lastnameedittext, contactnumberedittext;
Button startyourmembership;
CheckBox iagree;
TextView texturl,textView,change,costtoset,plannametoset;
String firstname,lastname,contactnumber;
String TAG = "Payment Error";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_payment_gate_way);
        getSupportActionBar ().hide ();
        Intent i = getIntent ();
        planname = i.getStringExtra ("planName");
        plancost = i.getStringExtra ("planCost");
        plancostformat=i.getStringExtra ("planCostFormat");
        UserEmailid = i.getStringExtra ("EmailId");
        UserPassword = i.getStringExtra ("Password");
        String TAG= "Payment Error";
        Checkout.preload(getApplicationContext());
        firstnameedittext = findViewById (R.id.firstnameedittext);
        lastnameedittext = findViewById (R.id.lastnameedittext);
        contactnumberedittext = findViewById (R.id.contactnumberedittext);
        startyourmembership = findViewById (R.id.startmembershipbutton);
        costtoset = findViewById (R.id.Costtoset);
        costtoset.setText (plancostformat);
        plannametoset = findViewById (R.id.plannametoset);
        plannametoset.setText (planname);
        iagree = findViewById (R.id.iagree);
        texturl = findViewById (R.id.toputurltext);
        textView = findViewById (R.id.step3of3);
        change = findViewById (R.id.Change);
        firstnameedittext = findViewById (R.id.firstnameedittext);
        lastnameedittext = findViewById (R.id.lastnameedittext);
        contactnumberedittext = findViewById (R.id.contactnumberedittext);

       firstname = firstnameedittext.getText ().toString ();
       lastname = firstnameedittext.getText().toString();
       contactnumber = firstnameedittext.getText().toString();
       Toast.makeText (this, ""+firstname + lastname+ contactnumber, Toast.LENGTH_SHORT).show ();

        SpannableString ss=new SpannableString("By checking the checkbox below, you agree to our Terms of Use, Privacy Statement, and that you are over 18. Netflix will automatically continue your membership and charge the monthly membership fee to your payment method until you cancel. You may cancel at any time to avoid future charges.");
        ClickableSpan clickableSpan = new ClickableSpan () {
            @Override
            public void onClick(@NonNull View view) {
                startActivity (new Intent (Intent.ACTION_VIEW, Uri.parse ("https://help.netflix.com/legaltermofuse")));

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState (ds);
                ds.setColor (Color.BLUE);
            }
        };



        ClickableSpan clickableSpan1 = new ClickableSpan () {
            @Override
            public void onClick(@NonNull View view) {
                startActivity (new Intent (Intent.ACTION_VIEW,Uri.parse ("https://help.netflix.com/legalprivacy")));
            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState (ds);
                ds.setColor (Color.BLUE);
            }
        };

        ss.setSpan (clickableSpan,49,61, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan (clickableSpan,63,80,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        texturl.setText(ss);
        texturl.setMovementMethod (LinkMovementMethod.getInstance ());


        change.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (PaymentGateWay.this,ChooseYourPlan.class);
                startActivity (i);
            }
        });
//            fetching data
          startyourmembership.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                startPayment ();

            }
        });
    }
    public  void startPayment() {
        Checkout checkout = new Checkout ();
        final Activity activity = this;
//        fetch the data
        firstname = firstnameedittext.getText ().toString ();
        lastname = lastnameedittext.getText ().toString ();
        contactnumber = contactnumberedittext.getText ().toString ();
        String name = firstname+lastname;
        try{
            JSONObject option = new JSONObject ();
            option.put("name",name);
            option.put("currency","INR");
            option.put("description","APP,Payment");
            String payment = plancost;
            double total = Double.parseDouble(payment);
            total = total*100;
            option.put("amount",total);
            option.put("prefill.email",UserEmailid);
            option.put("prefill.contact",contactnumber);
            checkout.open(activity,option);

        }
        catch (Exception e){
            Log.e(TAG,"error accured",e);
        }
    }



    @Override
    public void onPaymentSuccess(String s) {
        Toast.makeText (this, "payment successfull", Toast.LENGTH_SHORT).show ();

    }

    @Override
    public void onPaymentError(int i, String s) {
        Toast.makeText (this, "payment unsuccessfull", Toast.LENGTH_SHORT).show ();

    }
}