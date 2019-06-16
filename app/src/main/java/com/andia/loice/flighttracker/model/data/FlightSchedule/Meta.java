
package com.andia.loice.flighttracker.model.data.FlightSchedule;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Meta {

    @SerializedName("Link")
    private List<Link> mLink;
    @SerializedName("@Version")
    private String mVersion;

    public List<Link> getLink() {
        return mLink;
    }

    public void setLink(List<Link> link) {
        mLink = link;
    }

    public String getVersion() {
        return mVersion;
    }

    public void setVersion(String version) {
        mVersion = version;
    }

}
