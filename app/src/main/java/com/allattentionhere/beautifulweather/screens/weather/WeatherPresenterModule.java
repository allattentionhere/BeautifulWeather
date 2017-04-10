package com.allattentionhere.beautifulweather.screens.weather;


import dagger.Module;
import dagger.Provides;

/**
 * Created by krupenghetiya on 17/01/17.
 */

@Module
public class WeatherPresenterModule {
    private final WeatherContract.View mView;

    public WeatherPresenterModule(WeatherContract.View view) {
        mView = view;
    }

    @Provides
    WeatherContract.View provideWeatherContractView() {
        return mView;
    }
}
