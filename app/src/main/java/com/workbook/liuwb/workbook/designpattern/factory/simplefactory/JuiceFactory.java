package com.workbook.liuwb.workbook.designpattern.factory.simplefactory;

import com.workbook.liuwb.workbook.designpattern.factory.simplefactory.impl.AppleJuice;
import com.workbook.liuwb.workbook.designpattern.factory.simplefactory.impl.OrangeJuice;

/**
 * 工厂类
 */
public class JuiceFactory {

    /**
     * 根据名称来生产不同的果汁
     *
     * @param name
     * @return
     */
    public static IJuice createJuice(String name) {
        IJuice iJuice = null;
        if (name.equals("apple")) {
            iJuice = new AppleJuice();
        } else if (name.equals("orange")) {
            iJuice = new OrangeJuice();
        }

        return iJuice;
    }
}
