package com.workbook.liuwb.workbook.actions.designpattern.decorator.v2;

import com.workbook.liuwb.workbook.actions.designpattern.decorator.v1.SchoolReport;

public class HighScoreDecorator extends Decorator {

    public HighScoreDecorator(SchoolReport report) {
        super(report);
    }

    //我要汇报最高成绩
    private void reportHighScore() {
        System.out.println("这次考试语文最高是75，数学是78，自然是80");
    }

    @Override
    public void report() {
        this.reportHighScore();
        super.report();
    }
}
