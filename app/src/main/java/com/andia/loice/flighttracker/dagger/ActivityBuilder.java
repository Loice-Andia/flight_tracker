package com.andia.loice.flighttracker.dagger;

import com.andia.loice.flighttracker.view.activity.FlightListActivity;
import com.andia.loice.flighttracker.view.activity.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
abstract class ActivityBuilder {
    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();

    @ContributesAndroidInjector
    abstract FlightListActivity bindFlightListActivity();
}
