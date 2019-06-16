package com.andia.loice.flighttracker.dagger;

import com.andia.loice.flighttracker.App;
import com.andia.loice.flighttracker.dagger.module.AppModule;
import com.andia.loice.flighttracker.dagger.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ActivityBuilder.class,
        NetworkModule.class})
public interface AppComponent extends AndroidInjector<App> {
    @Component.Builder
    abstract class Builder extends AndroidInjector.Builder<App> {
    }
}
