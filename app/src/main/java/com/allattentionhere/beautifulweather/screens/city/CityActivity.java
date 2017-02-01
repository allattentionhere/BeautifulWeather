package com.allattentionhere.beautifulweather.screens.city;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.allattentionhere.beautifulweather.R;
import com.allattentionhere.beautifulweather.SkeletonApplication;
import com.allattentionhere.beautifulweather.dagger.DaggerSkeletonApplicationComponent;
import com.allattentionhere.beautifulweather.model.Cities;
import com.allattentionhere.beautifulweather.network.SkeletonServiceAPI;
import com.allattentionhere.beautifulweather.util.ActivityUtils;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Inject;

import butterknife.ButterKnife;

import static android.R.id.list;
import static android.R.string.no;


public class CityActivity extends AppCompatActivity {

    @Inject
    CityPresenter mCityPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
//        ButterKnife.bind(this);

        CityFragment cityFragment =
                (CityFragment) getSupportFragmentManager().findFragmentById(R.id.fl_content);
        if (cityFragment == null) {
            // Create the fragment
            cityFragment = CityFragment.newInstance();
            ActivityUtils.addFragmentToActivity(
                    getSupportFragmentManager(), cityFragment, R.id.fl_content);
        }

        // Create the presenter
        DaggerCityComponent.builder()
                .cityPresenterModule(new CityPresenterModule(cityFragment))
//                .skeletonApplicationComponent(SkeletonApplication.get(CityActivity.this).component())
                .build().inject(this);

    }





}
