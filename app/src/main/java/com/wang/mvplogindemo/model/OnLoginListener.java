package com.wang.mvplogindemo.model;

/**
 * Created by Wongerfeng on 2018/6/25.
 */

public interface OnLoginListener {
    /**
     *
     * @param userBean
     */
    void onLoginSuccess(UserBean userBean);
    void onLoginFailed();

}
