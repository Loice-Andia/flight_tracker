
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class MarketingCarrier {

    @SerializedName("AirlineID")
    private String mAirlineID;
    @SerializedName("FlightNumber")
    private Long mFlightNumber;

    public String getAirlineID() {
        return mAirlineID;
    }

    public void setAirlineID(String airlineID) {
        mAirlineID = airlineID;
    }

    public Long getFlightNumber() {
        return mFlightNumber;
    }

    public void setFlightNumber(Long flightNumber) {
        mFlightNumber = flightNumber;
    }

}
