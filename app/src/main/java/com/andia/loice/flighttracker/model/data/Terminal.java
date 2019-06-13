
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class Terminal {

    @SerializedName("Name")
    private Long mName;

    public Long getName() {
        return mName;
    }

    public void setName(Long name) {
        mName = name;
    }

}
