package com.allattentionhere.beautifulweather.screens.city;

import com.allattentionhere.beautifulweather.dagger.FragmentScoped;
import com.allattentionhere.beautifulweather.dagger.SkeletonApplicationComponent;

import dagger.Component;

/**
 * Created by krupenghetiya on 17/01/17.
 */

@FragmentScoped
@Component(modules = CityPresenterModule.class)
//@Component(dependencies = SkeletonApplicationComponent.class, modules = CityPresenterModule.class)
public interface CityComponent {
    void inject(CityActivity activity);

}
