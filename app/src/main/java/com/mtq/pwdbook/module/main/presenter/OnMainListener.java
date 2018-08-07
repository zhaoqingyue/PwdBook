package com.mtq.pwdbook.module.main.presenter;

import com.mtq.pwdbook.base.IBaseOnListener;
import com.mtq.pwdbook.module.main.data.User;

import java.util.ArrayList;

/**
 * Created by zhaoqy on 2018/7/19.
 */

public interface OnMainListener extends IBaseOnListener {

    void updateUser(ArrayList<User> list);
}
