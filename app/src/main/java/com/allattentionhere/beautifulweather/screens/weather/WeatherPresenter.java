package com.allattentionhere.beautifulweather.screens.weather;

import javax.inject.Inject;

/**
 * Created by krupenghetiya on 17/01/17.
 */

public class WeatherPresenter implements WeatherContract.Presenter {
    private final WeatherContract.View mWeatherView;

    @Inject
    WeatherPresenter(WeatherContract.View cityView) {
        mWeatherView = cityView;
    }

    @Inject
    void setupListeners() {
        mWeatherView.setPresenter(this);
    }


    @Override
    public void loadWeather() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void start() {
    }



}
