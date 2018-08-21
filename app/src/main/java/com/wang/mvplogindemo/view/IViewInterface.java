package com.wang.mvplogindemo.view;

import com.wang.mvplogindemo.model.UserBean;

/**
 * Created by Wongerfeng on 2018/6/25.
 */

public interface IViewInterface {
    /**
     * 获取用户输入用户名
     * @return
     */
    String getUserName();

    /**
     * 获取用户输入 密码
     * @return
     */
    String getPassword();

    /**
     * 用户清空操作
     */
    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    /**
     * 界面跳转
     * @param userBean
     */
    void toMainActivity(UserBean userBean);

    /**
     * 更新UI
     */
    void showFailedError();

}
