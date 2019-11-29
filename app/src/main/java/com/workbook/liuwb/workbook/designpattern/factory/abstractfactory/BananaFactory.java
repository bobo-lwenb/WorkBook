package com.workbook.liuwb.workbook.designpattern.factory.abstractfactory;

public class BananaFactory extends AbstractFactory {

    @Override
    Juice createJuice() {
        return new BananaJuice();
    }

    @Override
    Pie createPie() {
        return new BananaPie();
    }
}
