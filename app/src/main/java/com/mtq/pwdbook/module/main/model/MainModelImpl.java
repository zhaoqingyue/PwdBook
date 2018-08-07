package com.mtq.pwdbook.module.main.model;

import com.mtq.pwdbook.module.main.data.User;
import com.mtq.pwdbook.module.main.presenter.OnMainListener;

import java.util.ArrayList;

/**
 * Created by zhaoqy on 2018/7/19.
 */

public class MainModelImpl implements IMainModel {

    @Override
    public void getUser(OnMainListener listener) {

        ArrayList<User> list = new ArrayList<User>();
        User user = new User();
        user.setType(1);
        user.setTitle("简书");
        user.setName("zhaoqy");
        user.setPwd("123456");
        user.setTime(System.currentTimeMillis());
        user.setMemo("==");
        list.add(user);
        listener.updateUser(list);

        //listener.onFail("暂无密码备忘记录");

    }
}
