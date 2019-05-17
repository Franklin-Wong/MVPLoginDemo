package com.wang.mvplogindemo.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.wang.mvplogindemo.R;
import com.wang.mvplogindemo.model.UserBean;
import com.wang.mvplogindemo.pressentor.UserLoginPresenter;

public class MainActivity extends BaseActivity<IViewInterface, UserLoginPresenter> implements IViewInterface, View.OnClickListener {
    private static final String TAG = "MainActivity";

    private EditText mName,mPassword;
    private Button mSubmit, mClean;
    private ProgressBar mProgressBar;
//    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mName = findViewById(R.id.name);
        mPassword = findViewById(R.id.password);
        mSubmit = findViewById(R.id.submit);
        mClean = findViewById(R.id.clean);
        mProgressBar = findViewById(R.id.submit_pro);

        mSubmit.setOnClickListener(this);
        mClean.setOnClickListener(this);

    }

    @Override
    public UserLoginPresenter createPresenter() {
        return mPresenter = new UserLoginPresenter(this);
    }

    @Override
    public String getUserName() {
        Log.i(TAG, "getUserName: -----" + mName.getText());
        return mName.getText().toString();
    }

    @Override
    public String getPassword() {
        Log.i(TAG, "getPassword: -----" + mPassword.getText());
        return mPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mName.setText("");
    }

    @Override
    public void clearPassword() {
        mPassword.setText("");
    }

    @Override
    public void showLoading() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(UserBean userBean) {
        Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showFailedError() {
        Toast.makeText(this, "登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.submit:
                mPresenter.login();
//                mUserLoginPresenter.login();
                break;
            case R.id.clean:
                mPresenter.clear();
//                mUserLoginPresenter.clear();
                break;
            default:
                break;
        }

    }
}
