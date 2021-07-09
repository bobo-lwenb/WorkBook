package com.workbook.liuwb.workbook.actions.designpattern.factory.abstractfactory;

import com.workbook.liuwb.mylibrary.utils.Logger;

public class BananaPie implements Pie {

    @Override
    public void desc() {
        Logger.d(" BananaPie");
    }
}
