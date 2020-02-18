package com.workbook.liuwb.workbook.mvp.v2.presenter;

import android.os.Handler;

import com.workbook.liuwb.workbook.mvp.v2.bean.User;
import com.workbook.liuwb.workbook.mvp.v2.biz.IUserBiz;
import com.workbook.liuwb.workbook.mvp.v2.biz.OnLoginListener;
import com.workbook.liuwb.workbook.mvp.v2.biz.UserBizImpl;
import com.workbook.liuwb.workbook.mvp.v2.view.IUserLoginView;

public class UserLoginPresenter {

    private IUserBiz mUserBiz;
    private IUserLoginView loginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView view) {
        this.loginView = view;
        mUserBiz = new UserBizImpl();
    }

    public void login() {
        loginView.showLoading();
        mUserBiz.login(loginView.getUserName(), loginView.getPassword(), new OnLoginListener() {
            @Override
            public void loginSuccess(User user) {

            }

            @Override
            public void loginFailed() {

            }
        });
    }

    public void clear() {
        loginView.clearUserName();
        loginView.clearPassword();
    }

}
