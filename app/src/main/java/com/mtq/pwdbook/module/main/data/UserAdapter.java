package com.mtq.pwdbook.module.main.data;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.mtq.pwdbook.R;
import com.mtq.pwdbook.utils.TimeUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class UserAdapter extends BaseAdapter {

	private ArrayList<User> list;
	private Context mContext;

	public UserAdapter(Context context, ArrayList<User> list) {
		this.mContext = context;
		this.list = list;
	}

	public void setList(ArrayList<User> list) {
		this.list = list;
	}

	@Override
	public int getCount() {
		return list == null ? 0 : list.size();
	}

	@Override
	public User getItem(int position) {
		User item = null;
		if (null != list) {
			item = list.get(position);
		}
		return item;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(final int position, View view, ViewGroup parent) {
		final User item = getItem(position);
		if (item == null)
			return null;

		ViewHolder holder;
		if (view != null) {
			holder = (ViewHolder) view.getTag();
		} else {
			view = LayoutInflater.from(mContext).inflate(R.layout.item_user, parent, false);
			holder = new ViewHolder(view);
			view.setTag(holder);
		}

		holder.type.setText("类型：" + item.getType());
		holder.title.setText("标题：" + item.getTitle());
		holder.name.setText("用户名：" + item.getName());

		holder.pwd.setText("密码：" + item.getPwd());
		holder.time.setText("创建时间：" + TimeUtils.getConciseTime(item.getTime(), System.currentTimeMillis(), mContext));
		holder.memo.setText("备忘信息：" + item.getMemo());

		return view;
	}

	static class ViewHolder {

		@BindView(R.id.tv_type)
		TextView type;

		@BindView(R.id.tv_title)
		TextView title;

		@BindView(R.id.tv_name)
		TextView name;

		@BindView(R.id.tv_pwd)
		TextView pwd;

		@BindView(R.id.tv_time)
		TextView time;

		@BindView(R.id.tv_memo)
		TextView memo;

		public ViewHolder(View view) {
			ButterKnife.bind(this, view);
		}
	}
}
