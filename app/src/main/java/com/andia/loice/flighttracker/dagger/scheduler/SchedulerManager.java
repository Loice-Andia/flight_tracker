package com.andia.loice.flighttracker.dagger.scheduler;

import io.reactivex.Scheduler;

public interface SchedulerManager {
    Scheduler getIoScheduler();

    Scheduler getMainThreadScheduler();
}
