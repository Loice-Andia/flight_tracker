package com.andia.loice.flighttracker.viewmodel;

import com.andia.loice.flighttracker.dagger.scheduler.SchedulerManager;
import com.andia.loice.flighttracker.model.api.FlightScheduleRepo;
import com.andia.loice.flighttracker.model.data.FlightSchedule.ScheduleResource;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.disposables.CompositeDisposable;

public class FlightScheduleListViewModel extends ViewModel {

    private FlightScheduleRepo flightScheduleRepo;
    private SchedulerManager schedulerMngr;

    private MutableLiveData<ScheduleResource> flightSchedules = new MutableLiveData<>();
    private CompositeDisposable disposableManager = new CompositeDisposable();

    @Inject
    FlightScheduleListViewModel(SchedulerManager schedulerMngr, FlightScheduleRepo flightScheduleRepo) {
        this.flightScheduleRepo = flightScheduleRepo;
        this.schedulerMngr = schedulerMngr;
    }

    public MutableLiveData<ScheduleResource> getFlightSchedule() {
        if (flightSchedules.getValue() == null) {
            disposableManager.add()
//                    flightScheduleRepo.()
//                            .subscribeOn(schedulerMngr.getIoScheduler())
//                            .observeOn(schedulerMngr.getMainThreadScheduler())
//                            .subscribe(this.movies::setValue);
            ;
        }
        return flightSchedules;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        disposableManager.dispose();
    }
}
