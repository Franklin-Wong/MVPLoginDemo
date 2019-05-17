package com.wang.mvplogindemo.model;

/**
 * Created by Wongerfeng on 2018/6/25.
 */

public interface IModelInterface {
    /**
     * model业务逻辑
     * @param name
     * @param password
     * @param loginListener
     */
    void login( String name, String password, OnLoginListener loginListener);
}
