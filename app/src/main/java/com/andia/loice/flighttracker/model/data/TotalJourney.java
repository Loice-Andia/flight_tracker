
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class TotalJourney {

    @SerializedName("Duration")
    private String mDuration;

    public String getDuration() {
        return mDuration;
    }

    public void setDuration(String duration) {
        mDuration = duration;
    }

}
