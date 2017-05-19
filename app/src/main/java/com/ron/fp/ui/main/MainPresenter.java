package com.ron.fp.ui.main;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.ron.fp.data.DataManager;
import com.ron.fp.ui.base.BasePresenter;
import com.ron.fp.util.GlobalUtils;

import javax.inject.Inject;

import rx.Subscription;

public class MainPresenter extends BasePresenter<MainMvpView> {

    private final DataManager mDataManager;
    private Subscription mSubscription;
    private GlobalUtils globalUtils;

    @Inject
    public MainPresenter(DataManager dataManager, GlobalUtils globalUtils) {
        mDataManager = dataManager;
        this.globalUtils=globalUtils;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (mSubscription != null) mSubscription.unsubscribe();
    }

    public void replaceFragment(Fragment fragment, FragmentActivity contextFragment){
        globalUtils.replaceFragment(fragment,contextFragment);
    }
}
