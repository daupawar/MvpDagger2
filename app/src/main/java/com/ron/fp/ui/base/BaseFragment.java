package com.ron.fp.ui.base;

import android.support.v4.app.Fragment;

import com.ron.fp.MvpApplication;
import com.ron.fp.injection.component.ActivityComponent;

/**
 * Created by Rohan Pawar on 16/05/17.
 */

public class BaseFragment extends Fragment {

    private ActivityComponent mActivityComponent;

    public ActivityComponent activityComponent() {
        if (mActivityComponent == null) {
            mActivityComponent = MvpApplication.get(getActivity()).getActivityComponent(getActivity());
        }
        return mActivityComponent;
    }
}
