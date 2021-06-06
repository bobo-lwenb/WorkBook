package com.workbook.liuwb.workbook.designpattern.decorator.v2;

import com.workbook.liuwb.workbook.designpattern.decorator.v1.SchoolReport;

public class SortDecorator extends Decorator {
    public SortDecorator(SchoolReport report) {
        super(report);
    }

    //告诉老爸学校的排名情况
    private void reportSort() {
        System.out.println("我是排名第38名...");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
