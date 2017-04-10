package com.allattentionhere.beautifulweather.network;


import com.allattentionhere.beautifulweather.model.WeatherResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface SkeletonServiceAPI {

    @GET("data/2.5/weather")
    Call<WeatherResult> getCityWeather(
            @Query("q") String q,
            @Query("appid") String appid
    );

}
