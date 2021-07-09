package com.workbook.liuwb.workbook.actions.appstructure.mvp.v1;

/**
 * 定义view端的固有能力
 *
 * @param <T>
 */
public interface BaseView<T> {
    /**
     * View绑定Presenter时调用该方法
     * 可用于更新绑定的Presenter
     */
    void setPresenter(T presenter);
}
