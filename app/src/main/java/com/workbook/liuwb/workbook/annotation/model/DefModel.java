package com.workbook.liuwb.workbook.annotation.model;

import com.workbook.liuwb.workbook.annotation.annotations.UserInters;

public class DefModel {

    public static final int childe = 0x1;
    public static final int man = 0x2;
    public static final int girl = 0x3;
    public static final int other = 0x4;

    private int userType;

    @UserInters
    public int getUserType() {
        return userType;
    }

    public void setUserType(@UserInters int userType) {
        this.userType = userType;
    }

}
