package com.workbook.liuwb.workbook.actions.designpattern.strategy;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.actions.designpattern.strategy.strategyimpl.FlyNoWay;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super();
        super.setFlyStrategy(new FlyNoWay());// 选择/组装正确的策略接口Strategy实现，将策略实现注入到实现类之中
    }

    @Override
    public void display() {
        Logger.d(" RubberDuck diaplay");
    }

    @Override
    public void quack() {
        Logger.d(" RubberDuck quack");
    }
}
