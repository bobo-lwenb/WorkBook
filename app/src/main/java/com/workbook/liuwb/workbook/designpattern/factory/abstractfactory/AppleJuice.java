package com.workbook.liuwb.workbook.designpattern.factory.abstractfactory;

import com.workbook.liuwb.mylibrary.utils.Logger;

public class AppleJuice implements Juice {

    @Override
    public void desc() {
        Logger.d(" AppleJuice");
    }
}
