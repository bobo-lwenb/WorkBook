package com.workbook.liuwb.workbook.reflect;

import android.util.Log;

import java.io.Serializable;

public class Person implements Serializable {

    private String name;
    private int age;
    private float weight;

    Person() {
    }

    Person(String name, int age, float weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public String getName() {
        Log.e("ReflectActivity", "getName");
        return name;
    }

    public void setName(String name) {
        Log.e("ReflectActivity", "setName");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }
}
