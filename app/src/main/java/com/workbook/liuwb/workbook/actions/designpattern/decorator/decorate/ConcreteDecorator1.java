package com.workbook.liuwb.workbook.actions.designpattern.decorator.decorate;

public class ConcreteDecorator1 extends Decorator {
    public ConcreteDecorator1(Component component) {
        super(component);
    }

    //定义自己的修饰方法
    private void method1() {
        System.out.println("method1 修饰");
    }

    @Override
    public void operate() {
        this.method1();
        super.operate();
    }
}
