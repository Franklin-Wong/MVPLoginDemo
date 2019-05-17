package com.wang.mvplogindemo.pressentor;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * Created by Wongerfeng on 2018/8/21.
 */

public abstract class BasePresenter<T> {

    /**
     * 声明引用的变量
     */
    protected Reference<T> mViewRefer;

    /**
     * 使用WeakReference引用接口对象
     * @param view
     */
    public void attachView(T view){
        mViewRefer = new WeakReference<T>(view);
    }

    /**
     * 获取引用的接口对象
     * @return
     */
    private T getView(){
        return mViewRefer.get();
    }

    /**
     * 判断是否成功引用了接口对象
     * @return
     */
    public boolean isViewAttached(){
        return mViewRefer != null && mViewRefer.get() != null;
    }

    /**
     * 清空引用的接口对象
     */
    public void detachView(){
        if (mViewRefer != null){
            mViewRefer.clear();
            mViewRefer = null;
        }
    }
}
