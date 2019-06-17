package com.andia.loice.flighttracker.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.andia.loice.flighttracker.R;
import com.andia.loice.flighttracker.databinding.ActivityFlightListBinding;
import com.andia.loice.flighttracker.model.data.AccessToken;
import com.andia.loice.flighttracker.model.data.FlightSchedule.Schedule;
import com.andia.loice.flighttracker.view.adapter.FlightListAdapter;
import com.andia.loice.flighttracker.viewmodel.FlightScheduleListViewModel;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;
import timber.log.Timber;

import static com.andia.loice.flighttracker.utils.Constants.BASE_URL;

public class FlightListActivity extends DaggerAppCompatActivity {

    private ActivityFlightListBinding activityFlightListBinding;
    private FlightScheduleListViewModel flightScheduleListViewModel;

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private FlightListAdapter flightListAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFlightListBinding = DataBindingUtil.setContentView(this, R.layout.activity_flight_list);
        flightScheduleListViewModel = ViewModelProviders
                .of(FlightListActivity.this, viewModelFactory)
                .get(FlightScheduleListViewModel.class);

        recyclerView = activityFlightListBinding.flightListRcView;
        progressBar = new ProgressBar(this);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.VISIBLE);

        Intent intent = getIntent();

        String source = intent.getStringExtra("SOURCE");
        String dest = intent.getStringExtra("DEST");
        String deptDate = intent.getStringExtra("DEPARTURE");
        String retnDate = intent.getStringExtra("RETURN");

        String url = String.format("%soperations/schedules/%s/%s/%s", BASE_URL, source, dest, deptDate);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        getToken(url);

    }

    private void getToken(String url) {
        Timber.d("get token");
        final Observer<AccessToken> tokenObserver = results -> {

            Timber.d(results.toString());
            if (results == null) {
                Snackbar.make(recyclerView,
                        "Access token not received",
                        Snackbar.LENGTH_LONG)
                        .show();
            } else {
                fetchFlights(url, results.getAccessToken());
            }
            progressBar.setVisibility(View.GONE);
        };
        flightScheduleListViewModel.getToken().observe(this, tokenObserver);
    }


    private void fetchFlights(String url, String token) {
        Timber.d("Fetchhing flights");
        final Observer<List<Schedule>> flightsObserver = results -> {

            Timber.d(results.toString());
            if (results == null) {
                Snackbar.make(recyclerView,
                        "No flights found",
                        Snackbar.LENGTH_LONG)
                        .show();
            } else {
                displayFlights(results);
            }
            progressBar.setVisibility(View.GONE);
        };
        flightScheduleListViewModel.getFlightSchedule(url, token).observe(this, flightsObserver);
    }

    private void displayFlights(List<Schedule> results) {
        flightListAdapter = new FlightListAdapter(results);
        recyclerView.setAdapter(flightListAdapter);
        flightListAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}
