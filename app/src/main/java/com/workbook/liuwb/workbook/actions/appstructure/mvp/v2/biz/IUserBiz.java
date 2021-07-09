package com.workbook.liuwb.workbook.actions.appstructure.mvp.v2.biz;

public interface IUserBiz {
    public void login(String userName, String passWord, OnLoginListener loginListener);
}
