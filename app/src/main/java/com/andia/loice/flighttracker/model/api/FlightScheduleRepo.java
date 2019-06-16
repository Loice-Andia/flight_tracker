package com.andia.loice.flighttracker.model.api;

import com.andia.loice.flighttracker.dagger.scheduler.SchedulerManager;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class FlightScheduleRepo {

    private final CompositeDisposable disposableManager = new CompositeDisposable();
    private ApiService apiService;
    private SchedulerManager schedulerMngrImpl;

    @Inject
    public FlightScheduleRepo(ApiService apiService, SchedulerManager schedulerMngrImpl) {
        this.apiService = apiService;
        this.schedulerMngrImpl = schedulerMngrImpl;
    }

    private void fetchFromAPI() {
//        disposableManager.add(
//                apiService.getFlightSchedules()
//                        .subscribeOn(schedulerMngrImpl.getIoScheduler())
//                        .subscribe(response -> {}));
    }

}
