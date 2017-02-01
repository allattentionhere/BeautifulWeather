package com.allattentionhere.beautifulweather.screens.city;

import android.content.Context;
import android.support.annotation.NonNull;

import com.allattentionhere.beautifulweather.model.Cities;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by krupenghetiya on 17/01/17.
 */

public class CityPresenter implements CityContract.Presenter {
    private final CityContract.View mCityView;

    @Inject
    CityPresenter(CityContract.View cityView) {
        mCityView = cityView;
    }

    @Inject
    void setupListeners() {
        mCityView.setPresenter(this);
    }

    @Override
    public void loadAddedCities() {

    }

    @Override
    public void showError(String error) {

    }



    @Override
    public void loadSpinnerCities(Context c) {
        String obj;
        obj = loadJSONFromAsset(c);
        if (obj == null || obj.isEmpty()) {
            mCityView.showLoadingCitiesError();
        } else {
            Cities mCities = new Gson().fromJson(obj, Cities.class);
            mCityView.setSpinnerCities(mCities.getCities());
        }

    }

    @Override
    public void addNewCity() {
        //add to list
        mCityView.onCityAdded();
    }

    @Override
    public void removeCity(int position) {
        mCityView.onCityRemoved(position);


    }

    @Override
    public void start() {
    }

    public String loadJSONFromAsset(Context c) {
        String json = null;
        try {
            InputStream is = c.getAssets().open("cities.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;

    }

}
