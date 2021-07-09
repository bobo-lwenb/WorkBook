package com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.view;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.workbook.liuwb.workbook.R;
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.UserContract;
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.model.UserModel;
import com.workbook.liuwb.workbook.actions.appstructure.mvp.v1.presenter.UserPresenter;

public class UserActivity extends AppCompatActivity implements View.OnClickListener, UserContract.View {

    EditText mEtName;
    EditText mEtAge;
    Button mBtnConfirm;
    Button mBtnReset;

    private UserContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        createPresenter();

        mEtName = findViewById(R.id.et_name);
        mEtAge = findViewById(R.id.et_age);
        mBtnConfirm = findViewById(R.id.btn_confirm);
        mBtnReset = findViewById(R.id.btn_reset);

        mBtnConfirm.setOnClickListener(this);
        mBtnReset.setOnClickListener(this);
    }

    /**
     * 创建一个Presenter对象，让presenter持有view和model
     */
    public void createPresenter() {
        SharedPreferences sharedPreferences = getSharedPreferences("user_sp", Context.MODE_PRIVATE);
        UserModel model = new UserModel(sharedPreferences);
        mPresenter = new UserPresenter(model, this);
    }

    /**
     * 在onResume()函数中加载新数据并更新UI
     */
    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.start();
    }

    @Override
    public String getInputName() {
        return mEtName.getText().toString();
    }

    @Override
    public int getInputAge() {
        return Integer.valueOf(mEtAge.getText().toString());
    }

    @Override
    public void setName(String name) {
        mEtName.setText(name);
    }

    @Override
    public void setAge(int age) {
        mEtAge.setText(String.valueOf(age));
    }

    @Override
    public void setPresenter(UserContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_confirm:
                boolean isSuccess = mPresenter.saveUser();
                if (isSuccess) {
                    Toast.makeText(UserActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(UserActivity.this, "failed", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_reset:
                mPresenter.loadUser();
                break;
            default:
                break;
        }
    }
}
