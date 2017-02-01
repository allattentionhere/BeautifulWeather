package com.allattentionhere.beautifulweather.screens.weather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.allattentionhere.beautifulweather.R;
import com.allattentionhere.beautifulweather.util.ActivityUtils;

import javax.inject.Inject;

/**
 * Created by krupenghetiya on 01/02/17.
 */

public class WeatherActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
//        ButterKnife.bind(this);

        WeatherFragment weatherFragment =
                (WeatherFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (weatherFragment == null) {
            // Create the fragment
            weatherFragment = WeatherFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), weatherFragment, R.id.fl_content);
        }

        // Create the presenter
        DaggerWeatherComponent.builder()
                .weatherPresenterModule(new WeatherPresenterModule(weatherFragment))
//                .skeletonApplicationComponent(SkeletonApplication.get(WeatherActivity.this).component())
                .build().inject(this);

    }





}
