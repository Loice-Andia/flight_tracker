
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

public class Details {

    @SerializedName("DatePeriod")
    private DatePeriod mDatePeriod;
    @SerializedName("DaysOfOperation")
    private Long mDaysOfOperation;
    @SerializedName("Stops")
    private Stops mStops;

    public DatePeriod getDatePeriod() {
        return mDatePeriod;
    }

    public void setDatePeriod(DatePeriod datePeriod) {
        mDatePeriod = datePeriod;
    }

    public Long getDaysOfOperation() {
        return mDaysOfOperation;
    }

    public void setDaysOfOperation(Long daysOfOperation) {
        mDaysOfOperation = daysOfOperation;
    }

    public Stops getStops() {
        return mStops;
    }

    public void setStops(Stops stops) {
        mStops = stops;
    }

}
