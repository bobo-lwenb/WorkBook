package com.workbook.liuwb.workbook.designpattern.adapter;

// 调用类
public class User {

    private Target target;

    public User(Target target) {
        this.target = target;
    }

    public void call() {
        target.Request();
    }

}
