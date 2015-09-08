package com.example.bradcampbell;

import android.content.SharedPreferences;

import com.example.bradcampbell.data.HelloDiskCache;
import com.example.bradcampbell.data.HelloService;
import com.example.bradcampbell.domain.Clock;
import com.example.bradcampbell.domain.HelloModel;
import com.example.bradcampbell.domain.SchedulerProvider;

public class MockAppModule extends AppModule {
    private SharedPreferences overrideSharedPrefs;
    private HelloService overrideHelloService;
    private HelloDiskCache overrideHelloDiskCache;
    private SchedulerProvider overrideSchedulerProvider;
    private Clock overrideClock;
    private HelloModel overrideHelloModel;

    public MockAppModule(App app) {
        super(app);
    }

    public void setOverrideSharedPrefs(SharedPreferences overrideSharedPrefs) {
        this.overrideSharedPrefs = overrideSharedPrefs;
    }

    public void setOverrideHelloService(HelloService overrideHelloService) {
        this.overrideHelloService = overrideHelloService;
    }

    public void setOverrideHelloDiskCache(HelloDiskCache overrideHelloDiskCache) {
        this.overrideHelloDiskCache = overrideHelloDiskCache;
    }

    public void setOverrideSchedulerProvider(SchedulerProvider overrideSchedulerProvider) {
        this.overrideSchedulerProvider = overrideSchedulerProvider;
    }

    public void setOverrideClock(Clock overrideClock) {
        this.overrideClock = overrideClock;
    }

    public void setOverrideHelloModel(HelloModel overrideHelloModel) {
        this.overrideHelloModel = overrideHelloModel;
    }

    @Override
    public HelloModel provideHelloModel(SchedulerProvider schedulerProvider,
                                        HelloDiskCache helloDiskCache, HelloService helloService,
                                        Clock clock) {
        return overrideHelloModel != null ? overrideHelloModel :
                super.provideHelloModel(schedulerProvider, helloDiskCache, helloService, clock);
    }

    @Override public Clock provideClock() {
        return overrideClock != null ? overrideClock : super.provideClock();
    }

    @Override public SchedulerProvider provideSchedulerProvider() {
        return overrideSchedulerProvider != null ? overrideSchedulerProvider :
                super.provideSchedulerProvider();
    }

    @Override public SharedPreferences provideSharedPreferences() {
        return overrideSharedPrefs != null ? overrideSharedPrefs :
                super.provideSharedPreferences();
    }

    @Override public HelloDiskCache provideHelloDiskCache(SharedPreferences prefs) {
        return overrideHelloDiskCache != null ? overrideHelloDiskCache :
                super.provideHelloDiskCache(prefs);
    }

    @Override public HelloService provideHelloService() {
        return overrideHelloService != null ? overrideHelloService :
                super.provideHelloService();
    }
}