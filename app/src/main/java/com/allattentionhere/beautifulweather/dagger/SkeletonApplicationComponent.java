package com.allattentionhere.beautifulweather.dagger;

import com.allattentionhere.beautifulweather.network.SkeletonServiceAPI;
import com.allattentionhere.beautifulweather.screens.city.CityPresenterModule;
import com.squareup.picasso.Picasso;

import dagger.Component;

@SkeletonApplicationScope
@Component(modules = {SkeletonServiceModule.class, PicassoModule.class, ActivityModule.class})
public interface SkeletonApplicationComponent {

    Picasso getPicasso();

    SkeletonServiceAPI getSkeletonServiceAPI();
}
