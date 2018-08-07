package com.mtq.pwdbook.base;

/**
 * Created by zhaoqy on 2018/7/6.
 */

public interface IBaseView {

    void showProgress();

    void hideProgress();

    void onFail(String msg);
}
