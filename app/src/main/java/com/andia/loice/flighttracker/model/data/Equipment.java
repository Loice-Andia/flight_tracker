
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class Equipment {

    @SerializedName("AircraftCode")
    private Long mAircraftCode;

    public Long getAircraftCode() {
        return mAircraftCode;
    }

    public void setAircraftCode(Long aircraftCode) {
        mAircraftCode = aircraftCode;
    }

}
