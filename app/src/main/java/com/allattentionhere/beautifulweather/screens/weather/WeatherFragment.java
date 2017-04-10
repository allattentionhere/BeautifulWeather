package com.allattentionhere.beautifulweather.screens.weather;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.allattentionhere.beautifulweather.R;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by krupenghetiya on 17/01/17.
 */

public class WeatherFragment extends Fragment implements WeatherContract.View {

    private static final String TAG = "butterknife";
    @BindView(R.id.vp_cities)
    ViewPager vp_cities;
    @BindView(R.id.iv_menu)
    ImageView iv_menu;

    private Unbinder unbinder;

    private WeatherContract.Presenter mPresenter;
//    List<String> selected_cities = new ArrayList<>();

    public WeatherFragment() {
        // Requires empty public constructor
    }

    public static WeatherFragment newInstance() {
        return new WeatherFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mListAdapter = new CitiesAdapter(selected_cities, this);
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.frag_city, container, false);
        unbinder = ButterKnife.bind(this, root);

//        mPresenter.loadSpinnerCities(getActivity());
//
//        //todo below
//        rv_cities.setAdapter(mListAdapter);
//        rv_cities.setItemAnimator(new DefaultItemAnimator());
//        rv_cities.setLayoutManager(new LinearLayoutManager(getActivity()));
//        actv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                selected_city = actv_city.getText().toString();
//                btn_add.setEnabled(true);
//            }
//        });
//


        return root;
    }

//    @OnClick(btn_add)
//    public void onAddClick() {
//
//    }


    @Override
    public void setLoadingIndicator(boolean active) {
//        ll_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showWeather(List<String> cities) {

    }


    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void setPresenter(WeatherContract.Presenter presenter) {
        mPresenter = presenter;
    }


}
