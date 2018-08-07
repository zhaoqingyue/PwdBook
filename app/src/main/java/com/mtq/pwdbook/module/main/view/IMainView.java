package com.mtq.pwdbook.module.main.view;

import com.mtq.pwdbook.base.IBaseView;
import com.mtq.pwdbook.module.main.data.User;

import java.util.ArrayList;

/**
 * Created by zhaoqy on 2018/7/19.
 */

public interface IMainView extends IBaseView {

    void updateUser(ArrayList<User> list);
}
