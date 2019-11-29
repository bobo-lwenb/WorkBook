package com.workbook.liuwb.workbook.annotation;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.workbook.liuwb.workbook.R;
import com.workbook.liuwb.workbook.annotation.annotations.Gender;
import com.workbook.liuwb.workbook.annotation.annotations.UserInfo;
import com.workbook.liuwb.workbook.annotation.model.DefModel;
import com.workbook.liuwb.workbook.annotation.model.User;

import java.lang.reflect.Field;

import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.appcompat.app.AppCompatActivity;

public class AnnoActivity extends AppCompatActivity {

    private static final String TAG = "AnnoActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anno);

        DefModel model = new DefModel();
        model.setUserType(DefModel.childe);

        EditText text = new EditText(this);
        String temp = "111";
        testDo("12");

        Class clazz = User.class;
        if (clazz.isAnnotationPresent(UserInfo.class)) {
            UserInfo userInfo = (UserInfo) clazz.getAnnotation(UserInfo.class);
            assert userInfo != null;
            Log.e(TAG, userInfo.name() + "/" + userInfo.nickName() + "/" + userInfo.age() + "/" + userInfo.weight());
        }

        try {
            Field sex = clazz.getDeclaredField("sex");
            if (sex.isAnnotationPresent(Gender.class)) {
                Gender gender = sex.getAnnotation(Gender.class);
                Log.e(TAG, gender.gender() + "");
            }
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    private void testDo(@Size(min = 1, max = 2) String s) {
        Log.e("tag", "-------->" + s);

    }

}
