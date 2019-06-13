
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class Link {

    @SerializedName("@Href")
    private String mHref;
    @SerializedName("@Rel")
    private String mRel;

    public String getHref() {
        return mHref;
    }

    public void setHref(String href) {
        mHref = href;
    }

    public String getRel() {
        return mRel;
    }

    public void setRel(String rel) {
        mRel = rel;
    }

}
