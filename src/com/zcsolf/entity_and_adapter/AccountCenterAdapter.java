package com.zcsolf.entity_and_adapter;

import java.util.ArrayList;
import java.util.List;

import com.example.otherframejiangjunling.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountCenterAdapter extends BaseAdapter {
	private List<AccountCenter> list;
	private LayoutInflater inflater;

	public AccountCenterAdapter(Context context) {
		list = new ArrayList<AccountCenter>();
		inflater = LayoutInflater.from(context);
	}

	public void addItem(AccountCenter accountCenter) {
		list.add(accountCenter);
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
			convertView = inflater
					.inflate(R.layout.account_listview_item, null);
			holder = new ViewHolder();
			holder.ItemImage = (ImageView) convertView
					.findViewById(R.id.account_item_image);
			holder.ItemGoImage = (ImageView) convertView
					.findViewById(R.id.account_item_go);
			holder.ItemTitle = (TextView) convertView
					.findViewById(R.id.account_item_title);
			holder.ItemContent = (TextView) convertView
					.findViewById(R.id.account_item_content);
			holder.ItemExraContent = (TextView) convertView
					.findViewById(R.id.account_item_exracontent);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.ItemImage.setImageResource(list.get(position).getItemImage());
		holder.ItemGoImage.setImageResource(list.get(position).getItemGoImage());
		holder.ItemTitle.setText(list.get(position).getItemTitle());
		holder.ItemContent.setText(list.get(position).getItemContent());
		holder.ItemExraContent.setText(list.get(position).getItemExraContent());
		return convertView;
	}

	public class ViewHolder {
		ImageView ItemImage;
		ImageView ItemGoImage;
		TextView ItemTitle;
		TextView ItemContent;
		TextView ItemExraContent;
	}
}
