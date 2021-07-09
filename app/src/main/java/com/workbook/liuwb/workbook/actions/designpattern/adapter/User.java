package com.workbook.liuwb.workbook.actions.designpattern.adapter;

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
