package com.workbook.liuwb.workbook.designpattern.strategy;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.designpattern.strategy.strategyimpl.FlyWithWind;

public class GreenDuck extends Duck {

    public GreenDuck() {
        super();
        super.setFlyStrategy(new FlyWithWind());// 选择/组装正确的策略接口Strategy实现，将策略实现注入到实现类之中
    }

    @Override
    public void display() {
        Logger.d(" GreenDuck diaplay");
    }
}
