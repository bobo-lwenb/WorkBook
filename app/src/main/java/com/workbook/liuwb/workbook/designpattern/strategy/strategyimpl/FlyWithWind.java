package com.workbook.liuwb.workbook.designpattern.strategy.strategyimpl;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.designpattern.strategy.strategyinterface.FlyStrategy;

/**
 * 一个策略实现，或者说是算法家族成员
 */
public class FlyWithWind implements FlyStrategy {

    @Override
    public void performFly() {
        Logger.d(" FlyWithWind");
    }
}
