package com.allattentionhere.beautifulweather.screens.city;

import dagger.Module;
import dagger.Provides;

/**
 * Created by krupenghetiya on 17/01/17.
 */

@Module
public class CityPresenterModule {
    private final CityContract.View mView;

    public CityPresenterModule(CityContract.View view) {
        mView = view;
    }

    @Provides
    CityContract.View provideCityContractView() {
        return mView;
    }
}
