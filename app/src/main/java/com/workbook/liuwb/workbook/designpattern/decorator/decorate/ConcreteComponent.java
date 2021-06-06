package com.workbook.liuwb.workbook.designpattern.decorator.decorate;

public class ConcreteComponent extends Component {
    @Override
    public void operate() {
        System.out.println("do Something");
    }
}
