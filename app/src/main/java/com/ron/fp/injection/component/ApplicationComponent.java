package com.ron.fp.injection.component;

import android.app.Application;
import android.content.Context;

import com.ron.fp.MvpApplication;
import com.ron.fp.data.DataManager;
import com.ron.fp.data.local.PreferencesHelper;
import com.ron.fp.data.remote.RestService;
import com.ron.fp.injection.ApplicationContext;
import com.ron.fp.injection.module.ApplicationModule;
import com.ron.fp.service.BeaconService;
import com.ron.fp.util.RxEventBus;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(MvpApplication mvpApplication);
    void inject(BeaconService service);

    @ApplicationContext
    Context context();
    Application application();
    RestService restService();
    PreferencesHelper preferencesHelper();
    DataManager dataManager();
    RxEventBus eventBus();

}
