package com.ron.fp.injection.component;

import com.ron.fp.injection.PerActivity;
import com.ron.fp.injection.module.ActivityModule;
import com.ron.fp.ui.dashboard.DashboardFragment;
import com.ron.fp.ui.main.MainActivity;
import com.ron.fp.ui.signin.SigninActivity;
import com.ron.fp.ui.splash.SplashScreen;

import dagger.Component;

/**
 * This component inject dependencies to all Activities across the application
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainActivity);
    void inject(SplashScreen splashScreen);
    void inject(SigninActivity splashScreen);
    void inject(DashboardFragment dashboardFragment);

}
