package com.ron.fp.util;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.ron.fp.R;
import com.ron.fp.injection.ApplicationContext;

import javax.inject.Inject;

/**
 * Created by Rohan Pawar on 18/05/17.
 */

public class GlobalUtils  {

    Context mContext;

    @Inject
    public GlobalUtils(@ApplicationContext Context context) {
        this.mContext=context;
    }

    /**
     * replace old fragment with new one
     * if no fragment in back-stack  create it
     *
     * @param fragment
     */
    public void replaceFragment(Fragment fragment, FragmentActivity contextFragment) {

        try {
            String backStateName = fragment.getClass().getSimpleName();
            FragmentManager manager = contextFragment.getSupportFragmentManager();
            boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);
            FragmentTransaction ft = manager.beginTransaction();
            if (!fragmentPopped) {
                ft.replace(R.id.container, fragment, backStateName);
            }
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
