package com.workbook.liuwb.workbook.actions.designpattern.factory.simplefactory.impl;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.actions.designpattern.factory.simplefactory.IJuice;

public class OrangeJuice implements IJuice {

    @Override
    public String getName() {
        Logger.d(" OrangeJuice");
        return "OrangeJuice";
    }
}
