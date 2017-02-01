package com.allattentionhere.beautifulweather.screens.city;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.allattentionhere.beautifulweather.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemClick;
import butterknife.OnTextChanged;
import butterknife.Unbinder;

import static android.system.Os.remove;
import static android.util.Config.LOGD;
import static com.google.common.base.Preconditions.checkNotNull;


/**
 * Created by krupenghetiya on 17/01/17.
 */

public class CityFragment extends Fragment implements CityContract.View, CitiesAdapter.CityRemoveListener {

    private static final String TAG = "butterknife";
    @BindView(R.id.actv_city)
    AutoCompleteTextView actv_city;
    @BindView(R.id.rv_cities)
    RecyclerView rv_cities;
    @BindView(R.id.btn_add)
    Button btn_add;
    @BindView(R.id.btn_retry)
    Button btn_retry;
    @BindView(R.id.ll_progress)
    LinearLayout ll_progress;
    @BindView(R.id.ll_nocity)
    LinearLayout ll_nocity;
    @BindView(R.id.ll_city)
    LinearLayout ll_city;

    String selected_city = null;

    private Unbinder unbinder;

    private CityContract.Presenter mPresenter;
    private CitiesAdapter mListAdapter;
    List<String> selected_cities = new ArrayList<>();

    public CityFragment() {
        // Requires empty public constructor
    }

    public static CityFragment newInstance() {
        return new CityFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mListAdapter = new CitiesAdapter(selected_cities, this);
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

        mPresenter.loadSpinnerCities(getActivity());

        //todo below
        rv_cities.setAdapter(mListAdapter);
        rv_cities.setItemAnimator(new DefaultItemAnimator());
        rv_cities.setLayoutManager(new LinearLayoutManager(getActivity()));
        actv_city.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selected_city = actv_city.getText().toString();
                btn_add.setEnabled(true);
            }
        });

        actv_city.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                selected_city = null;
                btn_add.setEnabled(false);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        return root;
    }

    @OnClick(R.id.btn_add)
    public void onAddClick() {
        Log.d(TAG, "onAddClick: ");
        if (selected_cities.contains(selected_city)) {
            mPresenter.showError("City already added");
        } else {
            selected_cities.add(0, selected_city);
            mListAdapter.setCities(selected_cities);
            mPresenter.addNewCity();
            actv_city.setText("");

        }
    }


    @Override
    public void setLoadingIndicator(boolean active) {
        ll_city.setVisibility(View.GONE);
        ll_nocity.setVisibility(View.GONE);
        ll_progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void showAddedCities(List<String> cities) {
        ll_city.setVisibility(View.VISIBLE);
        ll_nocity.setVisibility(View.GONE);
        ll_progress.setVisibility(View.GONE);
    }

    @Override
    public void setSpinnerCities(List<String> cities) {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, cities);
        actv_city.setThreshold(2);
        actv_city.setAdapter(adapter);
    }

    @Override
    public void showLoadingCitiesError() {
        ll_city.setVisibility(View.GONE);
        ll_nocity.setVisibility(View.VISIBLE);
        ll_progress.setVisibility(View.GONE);

    }

    @Override
    public void onCityAdded() {
        mListAdapter.notifyItemInserted(0);
    }

    @Override
    public void onCityRemoved(int position) {
        mListAdapter.notifyItemRemoved(position);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getActivity(), error, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void setPresenter(CityContract.Presenter presenter) {
        mPresenter = presenter;
    }


    @Override
    public void onRemoveClicked(String city) {
        Log.d(TAG, "onRemoveClicked: city contains:" + selected_cities.contains(city));
        Log.d(TAG, "onRemoveClicked: city pos:" + selected_cities.indexOf(city));
        int pos =selected_cities.indexOf(city);
         selected_cities.remove(city);
        mListAdapter.setCities(selected_cities);
        mPresenter.removeCity(pos);
    }
}
