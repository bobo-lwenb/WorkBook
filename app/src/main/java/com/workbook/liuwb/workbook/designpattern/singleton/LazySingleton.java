package com.workbook.liuwb.workbook.designpattern.singleton;

/**
 * 懒汉模式
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }

    /**
     * 双重检查锁定（推荐）
     *
     * @return
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }
}
