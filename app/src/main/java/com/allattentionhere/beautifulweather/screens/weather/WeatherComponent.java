package com.allattentionhere.beautifulweather.screens.weather;

import com.allattentionhere.beautifulweather.dagger.FragmentScoped;
import com.allattentionhere.beautifulweather.dagger.SkeletonApplicationComponent;
import com.allattentionhere.beautifulweather.screens.city.CityActivity;
import com.allattentionhere.beautifulweather.screens.city.CityPresenterModule;

import dagger.Component;

/**
 * Created by krupenghetiya on 17/01/17.
 */

@FragmentScoped
@Component(dependencies = SkeletonApplicationComponent.class, modules = WeatherPresenterModule.class)
public interface WeatherComponent {
    void inject(WeatherActivity activity);

}
