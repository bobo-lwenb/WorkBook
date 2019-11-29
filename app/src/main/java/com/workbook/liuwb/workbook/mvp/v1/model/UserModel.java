package com.workbook.liuwb.workbook.mvp.v1.model;

import android.content.SharedPreferences;

import com.workbook.liuwb.workbook.mvp.v1.UserContract;

/**
 * Model具体实现类，实现加载数据和保存数据的实际方法
 */
public class UserModel implements UserContract.Model {

    private static final String SP_KEY_NAME = "name";
    private static final String SP_KEY_AGE = "age";

    private final SharedPreferences mSharedPreferences;

    public UserModel(SharedPreferences sharedPreferences) {
        this.mSharedPreferences = sharedPreferences;
    }

    /**
     * @return 从本地SharedPreferences中获取用户信息并返回
     */
    @Override
    public UserBean loadUser() {
        String name = mSharedPreferences.getString(SP_KEY_NAME, "defaultName");
        int age = mSharedPreferences.getInt(SP_KEY_AGE, 0);
        UserBean userBean = new UserBean();
        userBean.setName(name);
        userBean.setAge(age);
        return userBean;
    }

    @Override
    public boolean saveUser(UserBean userBean) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(SP_KEY_NAME, userBean.getName());
        editor.putInt(SP_KEY_AGE, userBean.getAge());
        return editor.commit();
    }
}
