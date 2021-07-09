package com.workbook.liuwb.workbook.actions.designpattern.factory.abstractfactory;

public class AppleFactory extends AbstractFactory {

    @Override
    Juice createJuice() {
        return new AppleJuice();
    }

    @Override
    Pie createPie() {
        return new ApplePie();
    }
}
