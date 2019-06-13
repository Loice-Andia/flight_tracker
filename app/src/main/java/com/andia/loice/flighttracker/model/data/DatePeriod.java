
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class DatePeriod {

    @SerializedName("Effective")
    private String mEffective;
    @SerializedName("Expiration")
    private String mExpiration;

    public String getEffective() {
        return mEffective;
    }

    public void setEffective(String effective) {
        mEffective = effective;
    }

    public String getExpiration() {
        return mExpiration;
    }

    public void setExpiration(String expiration) {
        mExpiration = expiration;
    }

}
