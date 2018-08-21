package com.wang.mvplogindemo.model;

/**
 * Created by Wongerfeng on 2018/6/25.
 */

public interface IModelInterface {
    void login( String name, String password, OnLoginListener loginListener);
}
