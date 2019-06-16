package com.andia.loice.flighttracker.dagger.module;

import android.content.Context;

import com.andia.loice.flighttracker.App;
import com.andia.loice.flighttracker.dagger.scheduler.IoScheduler;
import com.andia.loice.flighttracker.dagger.scheduler.MainScheduler;
import com.andia.loice.flighttracker.dagger.scheduler.SchedulerManager;
import com.andia.loice.flighttracker.dagger.scheduler.SchedulerMngrImpl;
import com.andia.loice.flighttracker.model.api.ApiService;
import com.andia.loice.flighttracker.model.api.FlightScheduleRepo;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@Module(includes = {ViewModelModule.class})
public class AppModule {
    @Provides
    @Singleton
    Context provideContext(App application) {
        return application.getApplicationContext();
    }

    @Provides
    @Reusable
    @MainScheduler
    Scheduler provideMainScheduler() {
        return AndroidSchedulers.mainThread();
    }

    @Provides
    @Reusable
    @IoScheduler
    Scheduler provideIoScheduler() {
        return Schedulers.io();
    }

    @Provides
    @Reusable
    SchedulerManager provideSchedulerManager(@NonNull @MainScheduler final Scheduler mainThreadScheduler,
                                             @NonNull @IoScheduler final Scheduler ioScheduler) {
        return new SchedulerMngrImpl(mainThreadScheduler, ioScheduler);
    }

    @Provides
    @Reusable
    FlightScheduleRepo providesFlightScheduleRepo(@NonNull ApiService apiService,
                                                  @NonNull SchedulerManager schedulerMngr) {
        return new FlightScheduleRepo(apiService, schedulerMngr);
    }

}
