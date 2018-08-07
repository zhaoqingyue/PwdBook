package com.mtq.pwdbook.module.main.view;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.mtq.pwdbook.R;
import com.mtq.pwdbook.base.BaseActivity;
import com.mtq.pwdbook.module.add.view.AddActivity;
import com.mtq.pwdbook.module.main.presenter.IMainPresenter;
import com.mtq.pwdbook.module.main.presenter.MainPresenterImpl;
import com.mtq.pwdbook.module.main.data.UserAdapter;
import com.mtq.pwdbook.module.main.data.User;
import com.mtq.pwdbook.module.setting.view.SettingActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity implements IMainView {

    @BindView(R.id.listView)
    ListView listView;

    @BindView(R.id.tv_empty)
    TextView empty;

    @BindView(R.id.pb_progress)
    ProgressBar progressBar;

    private UserAdapter adapter;
    private ArrayList<User> list;
    private IMainPresenter presenter;

    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected String getTitleName() {
        return getResources().getString(R.string.app_name);
    }

    @Override
    protected void initData() {
        presenter = new MainPresenterImpl(this);

        list = new ArrayList<User>();
        adapter = new UserAdapter(this, list);
        listView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        presenter.getUser();
    }

    @Override
    protected boolean isHasNaviIcon() {
        return false;
    }

    @Override
    protected int getRightResID() {
        return R.drawable.icon_settings;
    }

    @OnClick({R.id.fab, R.id.iv_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab: {
                Intent intent = new Intent(this, AddActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.iv_right: {
                Intent intent = new Intent(this, SettingActivity.class);
                startActivity(intent);
                break;
            }
        }
    }

    @Override
    public void updateUser(ArrayList<User> list) {
        this.list.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFail(String msg) {
        empty.setText(msg);
        listView.setEmptyView(empty);
    }
}
