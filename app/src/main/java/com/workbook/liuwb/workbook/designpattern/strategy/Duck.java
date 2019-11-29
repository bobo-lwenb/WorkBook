package com.workbook.liuwb.workbook.designpattern.strategy;

import com.workbook.liuwb.mylibrary.utils.Logger;
import com.workbook.liuwb.workbook.designpattern.strategy.strategyinterface.FlyStrategy;

/**
 * 基本框架
 */
public abstract class Duck {

    private FlyStrategy flyStrategy;// 在类中增加一个私有域，引用另一个已有类的实例

    public void quack() {
        Logger.d(" quack!");
    }

    /**
     * 鸭子的外观各不相同，声明为abstract，由子类实现
     */
    public abstract void display();

    public void fly() {
        flyStrategy.performFly();// 通过调用引用实例的方法而获得新的功能，由策略实现执行具体动作
    }

    public FlyStrategy getFlyStrategy() {
        return flyStrategy;
    }

    public void setFlyStrategy(FlyStrategy flyStrategy) {// 提供一个set方法，便于策略实现注入进来，就将具体行为代理给该对象的实现
        this.flyStrategy = flyStrategy;
    }
}
