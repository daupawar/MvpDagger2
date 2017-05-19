package com.ron.fp.ui.splash;

import com.ron.fp.ui.base.BasePresenter;

import javax.inject.Inject;

/**
 * Created by Rohan Pawar on 10/05/17.
 */

public class SplashPresenter extends BasePresenter<SplashMvpView> {

    @Inject
    public SplashPresenter() {

    }

    @Override
    public void attachView(SplashMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
    }
}
