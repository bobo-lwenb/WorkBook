package com.workbook.liuwb.workbook.actions.designpattern.strategy;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.actions.designpattern.strategy.strategyimpl.FlyWithWind;

public class RedDuck extends Duck {

    public RedDuck() {
        super();
        super.setFlyStrategy(new FlyWithWind());// 将策略实现注入到实现类之中
    }

    @Override
    public void display() {
        Logger.d(" RedDuck display");
    }
}
