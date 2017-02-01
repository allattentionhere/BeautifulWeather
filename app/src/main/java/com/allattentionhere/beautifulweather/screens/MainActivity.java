package com.allattentionhere.beautifulweather.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.allattentionhere.beautifulweather.R;

import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);
    }
}
