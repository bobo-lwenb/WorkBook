package com.workbook.liuwb.workbook.actions.designpattern.singleton;

/**
 * 饿汉模式
 */
public class HungrySingleton {

    private static final HungrySingleton single = new HungrySingleton();// 在类初始化时，已经自行实例化

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return single;
    }
}
