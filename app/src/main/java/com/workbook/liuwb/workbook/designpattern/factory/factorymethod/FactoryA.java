package com.workbook.liuwb.workbook.designpattern.factory.factorymethod;

/**
 * 具体工厂类
 */
public class FactoryA extends Factory {

    @Override
    public Product Manufacture() {
        return new ProductA();
    }
}
