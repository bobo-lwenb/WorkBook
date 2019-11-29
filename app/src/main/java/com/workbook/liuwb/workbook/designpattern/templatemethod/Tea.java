package com.workbook.liuwb.workbook.designpattern.templatemethod;

import com.workbook.liuwb.mylibrary.utils.Logger;

/**
 * 具体子类，提供一种具体实现
 */
public class Tea extends RefreshBeverage {

    @Override
    void brew() {
        Logger.d("brew Tea");
    }

    @Override
    void addCondimeants() {
        Logger.d("addCondimeants Tea");
    }

    /**
     * 子类通过覆盖的形式选择挂载钩子函数
     *
     * @return
     */
    @Override
    protected boolean isNeedCodimeants() {
        return false;
    }
}
