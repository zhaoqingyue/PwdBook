package com.mtq.pwdbook.module.main.presenter;

import com.mtq.pwdbook.module.main.data.User;
import com.mtq.pwdbook.module.main.model.IMainModel;
import com.mtq.pwdbook.module.main.model.MainModelImpl;
import com.mtq.pwdbook.module.main.view.IMainView;

import java.util.ArrayList;

/**
 * Created by zhaoqy on 2018/7/19.
 */

public class MainPresenterImpl implements IMainPresenter, OnMainListener {

    IMainView mainView;
    IMainModel mainModel;

    public MainPresenterImpl(IMainView mainView) {
        this.mainView = mainView;
        this.mainModel = new MainModelImpl();
    }

    @Override
    public void getUser() {
        if (mainView != null) {
            mainView.showProgress();
        }
        mainModel.getUser(this);
    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void updateUser(ArrayList<User> list) {
        if (mainView != null) {
            mainView.hideProgress();
            mainView.updateUser(list);
        }
    }

    @Override
    public void onFail(String msg) {
        if (mainView != null) {
            mainView.hideProgress();
            mainView.onFail(msg);
        }
    }
}
