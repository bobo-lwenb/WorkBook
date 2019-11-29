package com.workbook.liuwb.workbook.designpattern.factory.simplefactory.impl;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.designpattern.factory.simplefactory.IJuice;

/**
 * 一个具体的产品类
 */
public class AppleJuice implements IJuice {

    @Override
    public String getName() {
        Logger.d(" AppleJuice");
        return "AppleJuice";
    }
}
