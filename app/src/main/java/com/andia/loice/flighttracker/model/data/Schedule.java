
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class Schedule {

    @SerializedName("Flight")
    private Flight mFlight;
    @SerializedName("TotalJourney")
    private TotalJourney mTotalJourney;

    public Flight getFlight() {
        return mFlight;
    }

    public void setFlight(Flight flight) {
        mFlight = flight;
    }

    public TotalJourney getTotalJourney() {
        return mTotalJourney;
    }

    public void setTotalJourney(TotalJourney totalJourney) {
        mTotalJourney = totalJourney;
    }

}
