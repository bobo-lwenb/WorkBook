package com.workbook.liuwb.workbook.mvp.v2.biz;

import com.workbook.liuwb.workbook.mvp.v2.bean.User;

public class UserBizImpl implements IUserBiz {
    @Override
    public void login(String userName, String passWord, OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("zhy".equals(userName) && "123".equals(passWord)) {
                    User user = new User();
                    user.setUerName(userName);
                    user.setPassWord(passWord);
                    loginListener.loginSuccess(user);
                } else {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
