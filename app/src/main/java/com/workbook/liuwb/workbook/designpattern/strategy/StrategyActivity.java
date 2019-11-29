package com.workbook.liuwb.workbook.designpattern.strategy;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class StrategyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Duck duck = new GreenDuck();// 利用了多态的能力
        duck.display();
        duck.quack();
        duck.fly();

        Duck duck1 = new RedDuck();// 利用了多态的能力
        duck1.display();
        duck1.quack();
        duck1.fly();

        Duck duck2 = new RubberDuck();
        duck2.display();
        duck2.quack();
        duck2.fly();
    }
}
