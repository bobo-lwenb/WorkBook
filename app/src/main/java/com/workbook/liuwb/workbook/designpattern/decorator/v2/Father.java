package com.workbook.liuwb.workbook.designpattern.decorator.v2;

import com.workbook.liuwb.workbook.designpattern.decorator.v1.SchoolReport;
import com.workbook.liuwb.workbook.designpattern.decorator.v1.FouthGradeSchoolReport;

public class Father {
    public static void main(String[] args) {
        SchoolReport report;
        report = new FouthGradeSchoolReport();
        report = new HighScoreDecorator(report);
        report = new SortDecorator(report);
        report.report();
        report.sign("111");
    }
}
