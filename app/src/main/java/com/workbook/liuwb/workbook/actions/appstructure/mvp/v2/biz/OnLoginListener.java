package com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.biz;

import com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.bean.User;

public interface OnLoginListener {
    void loginSuccess(User user);

    void loginFailed();
}
