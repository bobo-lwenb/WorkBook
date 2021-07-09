package com.workbook.liuwb.workbook.actions.designpattern.factory.factorymethod;

/**
 * 具体工厂类
 */
public class FactoryB extends Factory {

    @Override
    public Product Manufacture() {
        return new ProductB();
    }
}
