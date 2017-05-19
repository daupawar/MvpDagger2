package com.ron.fp.data;

import com.ron.fp.data.local.PreferencesHelper;
import com.ron.fp.data.model.Profile;
import com.ron.fp.data.remote.ApiResponse;
import com.ron.fp.data.remote.RestService;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.Observable;


@Singleton
public class DataManager {

    private final RestService mRestService;

    private final PreferencesHelper mPreferencesHelper;

    @Inject
    public DataManager(RestService restService, PreferencesHelper preferencesHelper) {
        mRestService = restService;
        mPreferencesHelper = preferencesHelper;
    }

    public PreferencesHelper getPreferencesHelper() {
        return mPreferencesHelper;
    }

    public RestService getRestService() {
        return mRestService;
    }

    /**
     * login with username
     * @param username String
     * @param password String
     * @return ApiResponse<Profile>
     */
    public Observable<ApiResponse<Profile>> login(String username, String password) {
        return mRestService.signIn(username, password);
    }
}
