package com.andia.loice.flighttracker.view.activity;

import android.os.Bundle;

import com.andia.loice.flighttracker.R;
import com.andia.loice.flighttracker.databinding.ActivityFlightListBinding;
import com.andia.loice.flighttracker.viewmodel.FlightScheduleListViewModel;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

public class FlightListActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;
    private ActivityFlightListBinding activityFlightListBinding;
    private FlightScheduleListViewModel flightScheduleListViewModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityFlightListBinding = DataBindingUtil.setContentView(this, R.layout.activity_flight_list);
        flightScheduleListViewModel = ViewModelProviders.of(this, viewModelFactory).get(FlightScheduleListViewModel.class);
    }
}
