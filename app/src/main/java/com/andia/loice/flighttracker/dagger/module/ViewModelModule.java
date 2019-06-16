package com.andia.loice.flighttracker.dagger.module;

import com.andia.loice.flighttracker.dagger.ViewModelKey;
import com.andia.loice.flighttracker.viewmodel.FlightScheduleListViewModel;
import com.andia.loice.flighttracker.viewmodel.ViewModelFactory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(FlightScheduleListViewModel.class)
    abstract ViewModel bindsFlightScheduleListViewModel(FlightScheduleListViewModel movieListViewModel);

    @Binds
    abstract ViewModelProvider.Factory bindsViewModelFactory(ViewModelFactory viewModelFactory);

}
