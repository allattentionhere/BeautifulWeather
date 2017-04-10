package com.allattentionhere.beautifulweather.dagger;

import com.allattentionhere.beautifulweather.network.SkeletonServiceAPI;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module(includes = NetworkModule.class)
public class SkeletonServiceModule {

    private static final String BASE_URL = "http://api.openweathermap.org/";

    @Provides
    @SkeletonApplicationScope
    public SkeletonServiceAPI skeletonServiceAPI(Retrofit gitHubRetrofit) {
        return gitHubRetrofit.create(SkeletonServiceAPI.class);
    }

    @Provides
    @SkeletonApplicationScope
    public Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gsonBuilder.create();
    }

    @Provides
    @SkeletonApplicationScope
    public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl(BASE_URL)
                .build();
    }

}
