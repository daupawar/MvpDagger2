package com.ron.fp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ron.fp.R;
import com.ron.fp.ui.base.BaseFragment;

import javax.inject.Inject;


public class DashboardFragment extends BaseFragment implements DashboardView{

    @Inject DashboardPresenter presenter;

    public DashboardFragment() {
        // Required empty public constructor
    }


    public static DashboardFragment newInstance() {
        return new DashboardFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);
        activityComponent().inject(this);
        presenter.attachView(this);

        return view;
    }


    @Override public void onDestroyView() {
        super.onDestroyView();
        presenter.detachView();
    }

}
