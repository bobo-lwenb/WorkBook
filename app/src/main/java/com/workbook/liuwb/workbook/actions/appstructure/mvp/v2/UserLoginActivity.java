package com.workbook.liuwb.workbook.actions.appstructure.mvp.v2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.bean.User;
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.presenter.UserLoginPresenter;
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.view.IUserLoginView;

public class UserLoginActivity extends AppCompatActivity implements IUserLoginView {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserLoginPresenter presenter = new UserLoginPresenter(this);
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainActivity(User user) {

    }

    @Override
    public void showFailedError() {

    }
}
