package com.andia.loice.flighttracker.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.andia.loice.flighttracker.BuildConfig;
import com.andia.loice.flighttracker.dagger.scheduler.SchedulerManager;
import com.andia.loice.flighttracker.model.api.ApiService;
import com.andia.loice.flighttracker.model.data.AccessToken;
import com.andia.loice.flighttracker.model.data.FlightSchedule.Schedule;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class FlightScheduleListViewModel extends ViewModel {

    private ApiService apiService;
    private SchedulerManager schedulerMngr;

    private MutableLiveData<AccessToken> token = new MutableLiveData<>();
    private MutableLiveData<List<Schedule>> flightSchedules = new MutableLiveData<>();
    private CompositeDisposable disposableManager = new CompositeDisposable();

    @Inject
    FlightScheduleListViewModel(SchedulerManager schedulerMngr, ApiService apiService) {
        this.apiService = apiService;
        this.schedulerMngr = schedulerMngr;
    }

    public MutableLiveData<AccessToken> getToken() {
        disposableManager.add(
                apiService.getAccessToken(BuildConfig.api_key, BuildConfig.secret, "client_credentials")
                        .subscribeOn(schedulerMngr.getIoScheduler())
                        .subscribe(r -> token.postValue(r), throwable -> {
                            throw new Exception("no data");
                        })
        );

        return token;
    }

    public MutableLiveData<List<Schedule>> getFlightSchedule(String url, String token) {
        disposableManager.add(
                apiService.getFlightSchedules(url, String.format("Bearer %s", token))
                        .subscribeOn(schedulerMngr.getIoScheduler())
                        .subscribe(response -> flightSchedules.postValue(response.getSchedule()),
                                throwable -> {
                                    throw new Exception("no data");
                                }
                        ));

        return flightSchedules;
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        disposableManager.dispose();
    }
}
