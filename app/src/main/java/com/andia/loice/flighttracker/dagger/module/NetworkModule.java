package com.andia.loice.flighttracker.dagger.module;

import com.andia.loice.flighttracker.model.api.ApiService;
import com.andia.loice.flighttracker.model.api.ApiServiceFactory;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient() {
        return new ApiServiceFactory().provideClient();
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGson() {
        return new ApiServiceFactory().provideGsonConverterFactory();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor providesHttpLoggingInterceptor() {
        return new ApiServiceFactory().provideLoggingInterceptor();
    }

    @Provides
    @Singleton
    ApiService providesApiService() {
        return new ApiServiceFactory().providesApiService();
    }

}
