package com.allattentionhere.beautifulweather.screens.city;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.allattentionhere.beautifulweather.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by krupenghetiya on 20/01/17.
 */

public class CitiesAdapter extends RecyclerView.Adapter<CitiesAdapter.CityViewHolder> {

    private static final String TAG = "adapter";
    private List<String> mCities= new ArrayList<>();
    private CityRemoveListener mCityRemoveListener;

    public CitiesAdapter(List<String> cities, CityRemoveListener mCityRemoveListener) {
        Log.d(TAG, "CitiesAdapter: "+new Gson().toJson(cities));
        setCities(cities);
        this.mCityRemoveListener = mCityRemoveListener;
    }

    public void setCities(List<String> cities) {
        if (cities != null && cities.size() >= 0) {
            this.mCities.clear();
            this.mCities.addAll(cities);
        }
    }

    @Override
    public CityViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_city, parent, false);
        return new CitiesAdapter.CityViewHolder(itemView,mCityRemoveListener);
    }

    @Override
    public void onBindViewHolder(CityViewHolder holder, int position) {
        CitiesAdapter.CityViewHolder mHolder = (CitiesAdapter.CityViewHolder) holder;
        mHolder.setCity(mCities.get(position));
        Log.d(TAG, "onBindViewHolder: settext "+mCities.get(position));
    }

    @Override
    public int getItemCount() {
        return mCities.size();
    }

    public interface CityRemoveListener{
        void onRemoveClicked(String City);
    }

    public class CityViewHolder extends RecyclerView.ViewHolder {
        CityRemoveListener mCityRemoveListener;
        private String city;
        private TextView tv_title;
        private Button btn_remove;


        public CityViewHolder(View w,final CityRemoveListener mCityRemoveListener) {
            super(w);
            this.mCityRemoveListener=mCityRemoveListener;
            tv_title = ButterKnife.findById(w, R.id.tv_title);
            btn_remove = ButterKnife.findById(w, R.id.btn_remove);
            btn_remove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mCityRemoveListener.onRemoveClicked(city);
                }
            });
        }
        public void setCity(final String city) {
            this.city=city;
            tv_title.setText(city);

        }

    }

}
