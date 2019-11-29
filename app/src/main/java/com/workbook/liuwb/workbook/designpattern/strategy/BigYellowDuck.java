package com.workbook.liuwb.workbook.designpattern.strategy;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.designpattern.strategy.strategyimpl.FlyNoWay;

public class BigYellowDuck extends Duck {

    public BigYellowDuck() {
        super();
        super.setFlyStrategy(new FlyNoWay());// 选择/组装正确的策略接口Strategy实现，将策略实现注入到实现类之中
    }

    @Override
    public void display() {
        Logger.d(" BigYellowDuck display");
    }
}
