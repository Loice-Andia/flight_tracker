
package com.andia.loice.flighttracker.model.data.FlightSchedule;

import com.google.gson.annotations.SerializedName;

public class Flight {

    @SerializedName("Arrival")
    private Arrival mArrival;
    @SerializedName("Departure")
    private Departure mDeparture;
    @SerializedName("Details")
    private Details mDetails;
    @SerializedName("Equipment")
    private Equipment mEquipment;
    @SerializedName("MarketingCarrier")
    private MarketingCarrier mMarketingCarrier;
    @SerializedName("OperatingCarrier")
    private OperatingCarrier mOperatingCarrier;

    public Arrival getArrival() {
        return mArrival;
    }

    public void setArrival(Arrival arrival) {
        mArrival = arrival;
    }

    public Departure getDeparture() {
        return mDeparture;
    }

    public void setDeparture(Departure departure) {
        mDeparture = departure;
    }

    public Details getDetails() {
        return mDetails;
    }

    public void setDetails(Details details) {
        mDetails = details;
    }

    public Equipment getEquipment() {
        return mEquipment;
    }

    public void setEquipment(Equipment equipment) {
        mEquipment = equipment;
    }

    public MarketingCarrier getMarketingCarrier() {
        return mMarketingCarrier;
    }

    public void setMarketingCarrier(MarketingCarrier marketingCarrier) {
        mMarketingCarrier = marketingCarrier;
    }

    public OperatingCarrier getOperatingCarrier() {
        return mOperatingCarrier;
    }

    public void setOperatingCarrier(OperatingCarrier operatingCarrier) {
        mOperatingCarrier = operatingCarrier;
    }

}
