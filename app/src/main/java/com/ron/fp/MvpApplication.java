package com.ron.fp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.VisibleForTesting;

import com.ron.fp.injection.component.ActivityComponent;
import com.ron.fp.injection.component.ApplicationComponent;
import com.ron.fp.injection.component.DaggerActivityComponent;
import com.ron.fp.injection.component.DaggerApplicationComponent;
import com.ron.fp.injection.module.ActivityModule;
import com.ron.fp.injection.module.ApplicationModule;

public class MvpApplication extends Application {

    private ApplicationComponent mApplicationComponent;
    private ActivityComponent mActivityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public static MvpApplication get(Context context) {
        return (MvpApplication) context.getApplicationContext();
    }

    @VisibleForTesting
    protected ApplicationComponent createComponent() {
        return DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ActivityComponent getActivityComponent(Activity activity) {
        if (mActivityComponent == null) {
            mActivityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(activity))
                    .applicationComponent(getAppComponent())
                    .build();
        }
        return mActivityComponent;
    }

    public ApplicationComponent getAppComponent() {
        if (mApplicationComponent == null) {
            setComponent(createComponent());
        }
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }
}
