package com.workbook.liuwb.workbook.actions.designpattern.factory.factorymethod;

import com.workbook.liuwb.mylibrary.utils.Logger;

/**
 * 具体产品类
 */
public class ProductA extends Product {

    @Override
    public void Show() {
        Logger.d(" ProductA");
    }
}
