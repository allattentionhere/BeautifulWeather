package com.allattentionhere.beautifulweather.screens.weather;

import android.content.Context;

import com.allattentionhere.beautifulweather.screens.BasePresenter;
import com.allattentionhere.beautifulweather.screens.BaseView;

import java.util.List;

/**
 * Created by krupenghetiya on 17/01/17.
 */

public interface WeatherContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showWeather(List<String> cities);

        void showError(String error);

    }

    interface Presenter extends BasePresenter {

        void loadWeather();
        void showError(String error);

    }
}
