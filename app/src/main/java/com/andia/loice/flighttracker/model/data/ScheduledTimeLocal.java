
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class ScheduledTimeLocal {

    @SerializedName("DateTime")
    private String mDateTime;

    public String getDateTime() {
        return mDateTime;
    }

    public void setDateTime(String dateTime) {
        mDateTime = dateTime;
    }

}
