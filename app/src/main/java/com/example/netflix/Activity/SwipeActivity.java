package com.example.netflix.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.netflix.Adapter.viewPagerAdapter;
import com.example.netflix.R;

public class SwipeActivity extends AppCompatActivity {
    TextView signin, help, privacy;
    Button getstarted;
    ViewPager viewPagerswipe;
    LinearLayout slidedots;
    private int dotscount;
    private ImageView[] dots;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_swipe);
        getSupportActionBar ().hide ();
        help = findViewById (R.id.helptextview);
        signin = findViewById (R.id.signintextview);
        privacy = findViewById (R.id.privacytextview);
        viewPagerswipe = findViewById (R.id.viewpagerswipescreen);
        getstarted = findViewById (R.id.getstarted);
        slidedots = findViewById (R.id.sliderdots);
        viewPagerAdapter viewPagerAdapter = new viewPagerAdapter (this);
        viewPagerswipe.setAdapter (viewPagerAdapter);
        dotscount = viewPagerAdapter.getCount ();
        dots = new ImageView[dotscount];
        for (int i = 0; i < dotscount; i++) {
            dots[i] = new ImageView (this);
            dots[i].setImageDrawable (ContextCompat.getDrawable (getApplicationContext (),
                    R.drawable.inactivedots));
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins (4, 0, 4, 0);
            slidedots.addView (dots[i], params);
            dots[0].setImageDrawable (ContextCompat.getDrawable (getApplicationContext (), R.drawable.activedots));

            viewPagerswipe.addOnPageChangeListener (new ViewPager.OnPageChangeListener () {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    for (int i = 0; i < dotscount; i++) {
                        dots[i].setImageDrawable (ContextCompat.getDrawable (getApplicationContext (), R.drawable.inactivedots));
                    }
                    dots[position].setImageDrawable (ContextCompat.getDrawable (getApplicationContext (), R.drawable.activedots));

                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
            signin.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent (SwipeActivity.this, SigninActivity.class);
                    startActivity (i);
                }
            });
            privacy.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    startActivity (new Intent (Intent.ACTION_VIEW, Uri.parse ("https://help.netflix.com/en/node/100628")));
                }
            });
            help.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    startActivity (new Intent (Intent.ACTION_VIEW, Uri.parse ("https://help.netflix.com/en/")));
                }
            });
            getstarted.setOnClickListener (new View.OnClickListener () {
                @Override
                public void onClick(View view) {
                    Intent i = new Intent (SwipeActivity.this, StepOne.class);
                    startActivity (i);
                }
            });

        }
    }
}
