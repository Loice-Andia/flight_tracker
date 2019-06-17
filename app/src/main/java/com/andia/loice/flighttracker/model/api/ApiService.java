package com.andia.loice.flighttracker.model.api;

import com.andia.loice.flighttracker.model.data.AccessToken;
import com.andia.loice.flighttracker.model.data.FlightSchedule.ScheduleResource;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Url;

public interface ApiService {
    @GET
    Observable<ScheduleResource> getFlightSchedules(@Url String url,
                                                    @Header("Authorization") String token);

    @POST("oauth/token")
    @FormUrlEncoded
    Observable<AccessToken> getAccessToken(
            @Field("client_id") String client_id,
            @Field("client_secret") String client_secret,
            @Field("grant_type") String grant_type);

}
