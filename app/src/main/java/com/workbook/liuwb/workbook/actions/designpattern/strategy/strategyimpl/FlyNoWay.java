package com.workbook.liuwb.workbook.actions.designpattern.strategy.strategyimpl;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.actions.designpattern.strategy.strategyinterface.FlyStrategy;

/**
 * 另一个策略实现
 */
public class FlyNoWay implements FlyStrategy {

    @Override
    public void performFly() {
        Logger.d(" FlyNoWay");
    }
}
