package com.workbook.liuwb.workbook.designpattern.templatemethod;

import com.workbook.liuwb.mylibrary.utils.Logger;

/**
 * 具体子类，提供一种具体实现
 */
public class Coffe extends RefreshBeverage {

    @Override
    void brew() {
        Logger.d("brew Coffe");
    }

    @Override
    void addCondimeants() {
        Logger.d("addCondimeants Coffe");
    }
}
