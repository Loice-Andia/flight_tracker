
package com.andia.loice.flighttracker.model.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleResource {

    @SerializedName("Meta")
    private Meta mMeta;
    @SerializedName("Schedule")
    private List<Schedule> mSchedule;
    @SerializedName("ScheduleResource")
    private ScheduleResource mScheduleResource;

    public Meta getMeta() {
        return mMeta;
    }

    public void setMeta(Meta meta) {
        mMeta = meta;
    }

    public List<Schedule> getSchedule() {
        return mSchedule;
    }

    public void setSchedule(List<Schedule> schedule) {
        mSchedule = schedule;
    }

    public ScheduleResource getScheduleResource() {
        return mScheduleResource;
    }

    public void setScheduleResource(ScheduleResource scheduleResource) {
        mScheduleResource = scheduleResource;
    }

}
