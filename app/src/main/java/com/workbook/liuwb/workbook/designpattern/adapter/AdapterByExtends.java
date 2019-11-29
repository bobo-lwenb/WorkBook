package com.workbook.liuwb.workbook.designpattern.adapter;

// 适配器Adapter继承自Adaptee，同时又实现了目标(Target)接口。
public class AdapterByExtends extends Adaptee implements Target {

    @Override
    public void Request() {
        this.SpecificRequest();
    }
}
