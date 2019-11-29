package com.workbook.liuwb.workbook.reflect;

import android.os.Bundle;
import android.util.Log;

import com.workbook.liuwb.workbook.R;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ReflectActivity extends AppCompatActivity {

    private static final String TAG = "ReflectActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reflect);

        testField();
        testFunc();
    }

    private void testFunc() {
        try {
            Class clazz1 = Person.class;
            Person person1 = (Person) clazz1.newInstance();

            Field name = clazz1.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person1, "qaz");
            Log.e(TAG, name.getName() + "=========" + name.get(person1));

            Class clazz2 = Person.class;
            Constructor constructor = clazz2.getDeclaredConstructor(String.class, int.class, float.class);
            constructor.setAccessible(true);
            Person person2 = (Person) constructor.newInstance("plm", 33, 67);
            Log.e(TAG, person2.getName() + person2.getAge() + person2.getWeight());

            Person person = new Person("xiaominn", 20, 70);
            Class clazz3 = person.getClass();
            Method[] methods = clazz3.getDeclaredMethods();
            for (Method method : methods) {
                Log.e(TAG, "method:" + method.getName());
            }
            Method getName = clazz3.getMethod("getName");
            getName.invoke(person);
            Method setName = clazz3.getMethod("setName", String.class);
            setName.invoke(person, "zhangsan");

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private void testField() {
        Person person = new Person("lwb", 22, 65);
        Class personClass = person.getClass();

        try {
            Field[] fields = personClass.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String key = field.getName();
                Object value = field.get(person);
                Log.e(TAG, key + "++++++++++" + value);
            }

            Field name = personClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(person, "qaz");
            Log.e(TAG, name.getName() + "++++++++++" + name.get(person));
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
