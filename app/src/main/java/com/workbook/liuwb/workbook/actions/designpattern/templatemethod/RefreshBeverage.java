package com.workbook.liuwb.workbook.actions.designpattern.templatemethod;

import com.workbook.liuwb.mylibrary.utils.Logger;

/**
 * 抽象基类，为所有子类提供一个算法框架
 */
public abstract class RefreshBeverage {

    /**
     * 之所以用final，是不想子类去重写基类的该模版方法
     * 模版方法封装了所有子类必须共同遵守的算法框架，必须遵守好莱坞原则
     */
    public final void prepareBeverageTemplate() {
        boilWater();
        brew();
        pourInCap();
        if (isNeedCodimeants()) {
            addCondimeants();
        }
    }

    /**
     * Hook，钩子函数，提供一个默认或空的实现
     * 具体的子类可以自行决定是否挂钩以及如何挂钩
     *
     * @return
     */
    protected boolean isNeedCodimeants() {
        return true;
    }

    /**
     * 基本方法，不需要向子类开放该方法，向下屏蔽细节
     */
    private void boilWater() {
        Logger.d("boilWater");
    }

    abstract void brew();

    /**
     * 基本方法，不需要向子类开放该方法，向下屏蔽细节
     */
    private void pourInCap() {
        Logger.d("pourInCap");
    }

    abstract void addCondimeants();

}
