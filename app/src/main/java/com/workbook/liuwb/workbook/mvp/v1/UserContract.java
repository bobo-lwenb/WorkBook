package com.workbook.liuwb.workbook.mvp.v1;

import com.workbook.liuwb.workbook.mvp.v1.model.UserBean;

/**
 * 契约接口，用来存放User相关的Model，View 和 Presenter的接口
 */
public interface UserContract {
    interface Model {
        /**
         * 从SharedPreferences中获取UserBean对象
         *
         * @return 取得的对象
         */
        UserBean loadUser();

        /**
         * 将用户信息保存到SharedPreferences中
         *
         * @param userBean
         * @return 是否成功保存
         */
        boolean saveUser(UserBean userBean);
    }

    interface View extends BaseView<Presenter> {

        /**
         * @return 返回从编辑框输入的名字
         */
        String getInputName();

        /**
         * @return 返回从编辑框输入的年龄
         */
        int getInputAge();

        /**
         * 更新UI，更新显示姓名
         *
         * @param name
         */
        void setName(String name);

        /**
         * 更新UI，更新显示年龄
         *
         * @param age
         */
        void setAge(int age);

    }

    interface Presenter extends BasePresenter {

        /**
         * 加载用户信息
         */
        void loadUser();

        /**
         * @return 是否成功保存
         * 保存用户信息
         */
        boolean saveUser();

    }
}
