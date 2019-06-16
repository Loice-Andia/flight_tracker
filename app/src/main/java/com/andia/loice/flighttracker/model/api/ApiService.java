package com.andia.loice.flighttracker.model.api;

import com.andia.loice.flighttracker.model.data.FlightSchedule.ScheduleResource;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ScheduleResource> getFlightSchedules(@Url String url);
}
