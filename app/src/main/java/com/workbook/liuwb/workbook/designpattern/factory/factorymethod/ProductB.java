package com.workbook.liuwb.workbook.designpattern.factory.factorymethod;

import com.workbook.liuwb.mylibrary.utils.Logger;

/**
 * 具体产品类
 */
public class ProductB extends Product {

    @Override
    public void Show() {
        Logger.d(" ProductB");
    }
}
