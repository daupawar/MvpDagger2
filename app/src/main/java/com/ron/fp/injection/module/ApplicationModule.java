package com.ron.fp.injection.module;

import android.app.Application;
import android.content.Context;

import com.ron.fp.data.remote.RestService;
import com.ron.fp.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Provide application-level dependencies.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    RestService provideRestService() {
        return RestService.Creator.newRibotsService();
    }

}
