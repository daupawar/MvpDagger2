package com.ron.fp.ui.splash;

import com.ron.fp.data.model.Profile;
import com.ron.fp.ui.base.MvpView;

public interface SplashMvpView extends MvpView {

    void onLoginComplete(Profile profile);
}
