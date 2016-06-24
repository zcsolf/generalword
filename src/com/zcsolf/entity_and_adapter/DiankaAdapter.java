package com.zcsolf.entity_and_adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.otherframejiangjunling.R;

public class DiankaAdapter extends BaseAdapter {
	private List<Dianka> list;
	private LayoutInflater inflater;
	int flag = 0;

	public DiankaAdapter(Context context) {
		list = new ArrayList<Dianka>();
		inflater = LayoutInflater.from(context);
	}

	public void addItem(Dianka dianka) {
		list.add(dianka);
		this.notifyDataSetChanged();
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder = null;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.dianka_gridview_item, null);
			holder = new ViewHolder();

			holder.textView = (TextView) convertView
					.findViewById(R.id.dianka_gridview_text);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.textView.setText(list.get(position).getName());
		final TextView diankatv = (TextView) convertView
				.findViewById(R.id.dianka_gridview_text);
		diankatv.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (flag == 0) {
					v.setBackgroundResource(R.drawable.dianka_item_checked); // 选择充值点数后改变背景
					flag = 1;
				}
			}
		});
		return convertView;
	}

	public class ViewHolder {
		TextView textView;
	}
}
