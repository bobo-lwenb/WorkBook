package com.workbook.liuwb.workbook.annotation.model;

import com.workbook.liuwb.workbook.annotation.annotations.Gender;
import com.workbook.liuwb.workbook.annotation.annotations.UserInfo;

import java.io.Serializable;

@UserInfo(name = "xiaomin", nickName = "xm", age = 25, weight = 70)
public class User implements Serializable {

    @Gender(gender = Gender.GenderEnum.BOY)
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
