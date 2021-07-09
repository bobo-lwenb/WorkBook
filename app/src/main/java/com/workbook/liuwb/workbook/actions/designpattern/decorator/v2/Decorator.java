package com.workbook.liuwb.workbook.actions.designpattern.decorator.v2;

import com.workbook.liuwb.workbook.actions.designpattern.decorator.v1.SchoolReport;

public abstract class Decorator extends SchoolReport {
    private SchoolReport report;

    public Decorator(SchoolReport report) {
        this.report = report;
    }

    @Override
    public void report() {
        this.report.report();
    }

    @Override
    public void sign(String name) {
        this.report.sign(name);
    }
}
