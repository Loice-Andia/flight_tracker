package com.andia.loice.flighttracker.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.andia.loice.flighttracker.R;
import com.andia.loice.flighttracker.databinding.ActivityFlightListBinding;
import com.andia.loice.flighttracker.model.data.FlightSchedule.Schedule;
import com.andia.loice.flighttracker.view.adapter.FlightListAdapter;
import com.andia.loice.flighttracker.viewmodel.FlightScheduleListViewModel;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import dagger.android.support.DaggerAppCompatActivity;

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

        String url = String.format("{}/operations/schedules/{}/{}/{}", BASE_URL, source, dest, deptDate);

        fetchFlights(url);

    }

    private void fetchFlights(String url) {
        final Observer<List<Schedule>> flightsObserver = results -> {
            displayFlights(results);
            progressBar.setVisibility(View.GONE);
        };
        flightScheduleListViewModel.getFlightSchedule(url).observe(this, flightsObserver);
    }

    private void displayFlights(List<Schedule> results) {
        flightListAdapter = new FlightListAdapter(results);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(flightListAdapter);
        flightListAdapter.notifyDataSetChanged();
        progressBar.setVisibility(View.GONE);
    }
}
