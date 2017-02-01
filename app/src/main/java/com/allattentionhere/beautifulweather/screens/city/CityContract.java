package com.allattentionhere.beautifulweather.screens.city;

import android.content.Context;
import android.support.annotation.NonNull;

import com.allattentionhere.beautifulweather.screens.BasePresenter;
import com.allattentionhere.beautifulweather.screens.BaseView;

import java.util.List;

/**
 * Created by krupenghetiya on 17/01/17.
 */

public interface CityContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showAddedCities(List<String> cities);
        void setSpinnerCities(List<String> cities);

        void showLoadingCitiesError();


        void onCityAdded();
        void onCityRemoved(int position);

        void showError(String error);

    }

    interface Presenter extends BasePresenter {

        void loadAddedCities();
        void showError(String error);
        void loadSpinnerCities(Context c);

        void addNewCity();
        void removeCity(int position);

    }
}
