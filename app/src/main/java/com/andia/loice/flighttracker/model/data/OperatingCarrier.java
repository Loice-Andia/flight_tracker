
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class OperatingCarrier {

    @SerializedName("AirlineID")
    private String mAirlineID;

    public String getAirlineID() {
        return mAirlineID;
    }

    public void setAirlineID(String airlineID) {
        mAirlineID = airlineID;
    }

}
