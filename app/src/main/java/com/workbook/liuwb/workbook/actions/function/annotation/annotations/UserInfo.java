package com.workbook.liuwb.workbook.actions.function.annotation.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface UserInfo {
    String name();

    String nickName() default "Tom";

    int age() default 20;

    int weight() default 65;
}
