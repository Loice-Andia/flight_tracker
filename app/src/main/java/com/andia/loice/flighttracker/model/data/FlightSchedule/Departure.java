
package com.andia.loice.flighttracker.model.data.FlightSchedule;

import com.google.gson.annotations.SerializedName;

public class Departure {

    @SerializedName("AirportCode")
    private String mAirportCode;
    @SerializedName("ScheduledTimeLocal")
    private ScheduledTimeLocal mScheduledTimeLocal;

    public String getAirportCode() {
        return mAirportCode;
    }

    public void setAirportCode(String airportCode) {
        mAirportCode = airportCode;
    }

    public ScheduledTimeLocal getScheduledTimeLocal() {
        return mScheduledTimeLocal;
    }

    public void setScheduledTimeLocal(ScheduledTimeLocal scheduledTimeLocal) {
        mScheduledTimeLocal = scheduledTimeLocal;
    }

}
