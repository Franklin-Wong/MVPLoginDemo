package com.wang.mvplogindemo.pressentor;

import android.os.Handler;
import android.util.Log;

import com.wang.mvplogindemo.model.IModelInterface;
import com.wang.mvplogindemo.model.OnLoginListener;
import com.wang.mvplogindemo.model.UserBean;
import com.wang.mvplogindemo.model.Model;
import com.wang.mvplogindemo.view.IViewInterface;


/**
 * Created by Wongerfeng on 2018/6/26.
 */

public class UserLoginPresenter {
    private static final String TAG = "UserLoginPresenter";
    //多态 子类实例化接口
    private IModelInterface mIModelInterface;
    //
    private IViewInterface mIViewInterface;
    /**消息机制*/
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IViewInterface IViewInterface) {
        mIViewInterface = IViewInterface;
        this.mIModelInterface = new Model();
    }

    public void login(){
        Log.i(TAG, "login: -----------------");
        mIViewInterface.showLoading();
        mIModelInterface.login(mIViewInterface.getUserName(), mIViewInterface.getPassword(),
                new OnLoginListener() {
                    @Override
                    public void onLoginSuccess(final UserBean userBean) {
                        Log.i(TAG, "onLoginSuccess: -------------");
                        //更新UI的操作
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mIViewInterface.hideLoading();
                                mIViewInterface.toMainActivity(userBean);
                            }
                        });
                    }

                    @Override
                    public void onLoginFailed() {
                        Log.i(TAG, "onLoginFailed: -------------");
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mIViewInterface.hideLoading();
                                mIViewInterface.showFailedError();
                            }
                        });
                    }
                });
    }

    /**
     *
     */
    public void clear(){
        mIViewInterface.clearUserName();
        mIViewInterface.clearPassword();
    }

}
