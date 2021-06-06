package com.workbook.liuwb.workbook.designpattern.decorator.v1;

public class Father {
    public static void main(String[] args) {
        SchoolReport report = new SugarFouthGradeSchoolReport();
        //看成绩单
        report.report();
        //无法签名
        report.sign("老三");
    }
}
