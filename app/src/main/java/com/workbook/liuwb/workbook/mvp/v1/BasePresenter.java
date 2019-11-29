package com.workbook.liuwb.workbook.mvp.v1;

/**
 * 定义presenter端的固有能力
 */
public interface BasePresenter {
    /**
     * 用于触发数据加载，一般在onResume中
     */
    void start();
}
