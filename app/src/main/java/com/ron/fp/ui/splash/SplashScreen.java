package com.ron.fp.ui.splash;

import android.os.Bundle;

import com.ron.fp.R;
import com.ron.fp.data.model.Profile;
import com.ron.fp.ui.base.BaseActivity;
import com.ron.fp.ui.signin.SigninActivity;

import java.util.Timer;
import java.util.TimerTask;

import javax.inject.Inject;

public class SplashScreen extends BaseActivity implements SplashMvpView {

    @Inject
    SplashPresenter splashPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        activityComponent().inject(this);
        splashPresenter.attachView(this);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(SigninActivity.getStartIntent(SplashScreen.this));
                finish();
            }
        }, 3000);
    }

    @Override
    public void onLoginComplete(Profile profile) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        splashPresenter.detachView();
    }
}
