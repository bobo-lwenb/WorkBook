package com.workbook.liuwb.workbook.actions.designpattern.factory.abstractfactory;

import com.workbook.liuwb.mylibrary.utils.Logger;

public class BananaJuice implements Juice {

    @Override
    public void desc() {
        Logger.d(" BananaJuice");
    }
}
