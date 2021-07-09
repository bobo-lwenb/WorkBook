package com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.view;

import com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.bean.User;

public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();
}
