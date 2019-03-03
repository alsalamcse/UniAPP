package com.example.owner.uniapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    private TextView TvWelcome, TvText, tvAccount1;
    private Button btnGetStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        TvText = (TextView) findViewById(R.id.tvText);
        TvWelcome = (TextView) findViewById(R.id.tvWelCome);
        btnGetStart = (Button) findViewById(R.id.btnGetStarted);
        tvAccount1 = (TextView) findViewById(R.id.tvAccount1);



        btnGetStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashActivity.this, SingUpActivity.class);
                startActivity(i);
            }
        });
        tvAccount1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SplashActivity.this, SignIn.class);
                startActivity(i);
            }
        });
    }
}
