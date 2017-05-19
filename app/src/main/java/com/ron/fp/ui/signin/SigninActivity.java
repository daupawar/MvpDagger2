package com.ron.fp.ui.signin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ron.fp.R;
import com.ron.fp.ui.base.BaseActivity;
import com.ron.fp.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A login screen that offers login via email/password.
 */
public class SigninActivity extends BaseActivity implements SigninMvpView {


    @Inject
    SigninPresenter mSignInPresenter;

    /**
     * Return an Intent to start this Activity.
     */
    public static Intent getStartIntent(Context context) {
        return new Intent(context, SigninActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        activityComponent().inject(this);
        ButterKnife.bind(this);
        mSignInPresenter.attachView(this);
    }


    @OnClick(R.id.LoginWithMobile)
    public void onClickLoginButton() {
        //TODO addd original data here
        mSignInPresenter.doLogin("", "");
    }

    @Override
    public void onLoginSuccess() {
        finish();
        startActivity(MainActivity.getStartIntent(this));
    }

    @Override
    public void onFailure(Throwable e) {
        Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
    }
}

