package com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.presenter;

import com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.UserContract;
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.model.UserBean;

public class UserPresenter implements UserContract.Presenter {

    private final UserContract.Model mModel;
    private final UserContract.View mView;

    public UserPresenter(UserContract.Model model, UserContract.View view) {
        mModel = model;
        mView = view;
        mView.setPresenter(this);// 实现View和Presenter的绑定
    }

    @Override
    public void loadUser() {
        UserBean userBean = mModel.loadUser();
        mView.setName(userBean.getName());
        mView.setAge(userBean.getAge());
    }

    @Override
    public boolean saveUser() {
        UserBean userBean = new UserBean();
        userBean.setName(mView.getInputName());
        userBean.setAge(mView.getInputAge());
        return mModel.saveUser(userBean);
    }

    @Override
    public void start() {
        loadUser();
    }
}
