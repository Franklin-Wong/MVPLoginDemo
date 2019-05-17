package com.wang.mvplogindemo.model;

import android.util.Log;

/**
 * Created by Wongerfeng on 2018/6/25.
 */

public class Model implements IModelInterface {
    private static final String TAG = "UserModel";

    private UserBean mUserBean;

    @Override
    public void login(final String name, final String password, final OnLoginListener loginListener) {

        Log.i(TAG, "login: ----------------");
        new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (name.equalsIgnoreCase("aaa")
                        && password.equalsIgnoreCase("aaa")){
                    mUserBean = new UserBean();
                    mUserBean.setName(name);
                    mUserBean.setPassword(password);
                    Log.i(TAG, "run: -------------onLoginSuccess--name-----"+name);
                    loginListener.onLoginSuccess(mUserBean);
                }else {
                    Log.i(TAG, "run: -----------onLoginFailed");
                    loginListener.onLoginFailed();
                }

            }
        }.start();

    }
}
