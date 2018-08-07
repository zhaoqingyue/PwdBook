package com.mtq.pwdbook.module.main.data;


import com.mtq.pwdbook.utils.encrypt.Base64Util;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by zhaoqy on 2018/7/19.
 */

public class User extends RealmObject {

    private int type;      // 密码所属的分组
    @PrimaryKey
    private String title;  // 标题，注明该账号为哪个网站的账号
    private String name;   // 用户名
    private String pwd;    // 密码
    private long time;     // 创建的时间,或者修改时间
    private String memo;   // 备忘信息

    public User() {

    }

    public User(int type, String title, String name, String pwd, long time, String memo) {
        this.type = type;
        this.title = Base64Util.encryptBASE64(title);
        this.name = Base64Util.encryptBASE64(name);
        this.pwd = Base64Util.encryptBASE64(pwd);
        this.time = time;
        this.memo = Base64Util.encryptBASE64(memo);
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName() {
        return Base64Util.decryptBASE64(name);
    }

    public void setName(String name) {
        this.name = Base64Util.encryptBASE64(name);
    }

    public String getPwd() {
        return Base64Util.decryptBASE64(pwd);
    }

    public void setPwd(String pwd) {
        this.pwd = Base64Util.encryptBASE64(pwd);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return Base64Util.decryptBASE64(title);
    }

    public void setTitle(String title) {
        this.title = Base64Util.encryptBASE64(title);
    }

    public String getMemo() {
        return Base64Util.decryptBASE64(memo);
    }

    public void setMemo(String memo) {
        this.memo = Base64Util.encryptBASE64(memo);
    }
}
