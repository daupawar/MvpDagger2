package com.ron.fp.ui.signin;

import com.ron.fp.ui.base.MvpView;

/**
 * Created by Rohan Pawar on 11/05/17.
 */

public interface SigninMvpView extends MvpView {

    void onLoginSuccess();

    void onFailure(Throwable e);
}
