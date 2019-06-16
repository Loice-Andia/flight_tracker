package com.andia.loice.flighttracker.viewmodel;

import com.andia.loice.flighttracker.dagger.scheduler.SchedulerManager;
import com.andia.loice.flighttracker.model.api.ApiService;
import com.andia.loice.flighttracker.model.data.FlightSchedule.Schedule;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class FlightScheduleListViewModel extends ViewModel {

    private ApiService apiService;
    private SchedulerManager schedulerMngr;

    private MutableLiveData<List<Schedule>> flightSchedules = new MutableLiveData<>();
    private CompositeDisposable disposableManager = new CompositeDisposable();

    @Inject
    FlightScheduleListViewModel(SchedulerManager schedulerMngr, ApiService apiService) {
        this.apiService = apiService;
        this.schedulerMngr = schedulerMngr;
    }

    public MutableLiveData<List<Schedule>> getFlightSchedule(String url) {
        if (flightSchedules == null) {
            disposableManager.add(
                    apiService.getFlightSchedules(url)
                            .subscribeOn(schedulerMngr.getIoScheduler())
                            .subscribe(response -> flightSchedules.setValue(response.getSchedule())));
        }
        return flightSchedules;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposableManager.dispose();
    }
}
