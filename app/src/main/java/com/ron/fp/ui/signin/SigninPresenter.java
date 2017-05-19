package com.ron.fp.ui.signin;

import android.util.Log;

import com.ron.fp.data.DataManager;
import com.ron.fp.data.model.Profile;
import com.ron.fp.data.remote.ApiResponse;
import com.ron.fp.ui.base.BasePresenter;

import javax.inject.Inject;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Rohan Pawar on 11/05/17.
 */

public class SigninPresenter extends BasePresenter<SigninMvpView> {

    private SigninMvpView signinMvpView;
    private final DataManager mDataManager;
    private Subscription mSubscription;

    @Inject
    public SigninPresenter(DataManager dataManager) {
        mDataManager = dataManager;
    }

    @Override
    public void attachView(final SigninMvpView mvpView) {
        super.attachView(mvpView);
        signinMvpView = mvpView;
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public boolean isPasswordValid(String password) {
        return password.length() >= 10;
    }

    public boolean isEmailValid(String email) {
        return email.contains("@");
    }

    public void doLogin(String username, String password) {
        mSubscription = mDataManager.login(username, password)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ApiResponse<Profile>>() {
                    @Override
                    public void onCompleted() {
                        Log.i("login", "On complete");
                        signinMvpView.onLoginSuccess();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("login", e.toString());
                        signinMvpView.onFailure(e);
                    }

                    @Override
                    public void onNext(ApiResponse<Profile> response) {
                        Profile profile = response.content;
                        Log.i("login", profile.getFullname());
                    }
                });
    }


}
