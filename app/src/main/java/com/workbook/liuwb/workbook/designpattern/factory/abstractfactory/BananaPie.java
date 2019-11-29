package com.workbook.liuwb.workbook.designpattern.factory.abstractfactory;

import com.workbook.liuwb.mylibrary.utils.Logger;

public class BananaPie implements Pie {

    @Override
    public void desc() {
        Logger.d(" BananaPie");
    }
}
