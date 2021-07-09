package com.workbook.liuwb.workbook.actions.designpattern.factory.abstractfactory;

import com.workbook.liuwb.mylibrary.utils.Logger;

public class ApplePie implements Pie {

    @Override
    public void desc() {
        Logger.d(" ApplePie");
    }
}
