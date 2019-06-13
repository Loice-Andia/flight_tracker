
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class Stops {

    @SerializedName("StopQuantity")
    private Long mStopQuantity;

    public Long getStopQuantity() {
        return mStopQuantity;
    }

    public void setStopQuantity(Long stopQuantity) {
        mStopQuantity = stopQuantity;
    }

}
