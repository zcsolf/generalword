package com.zcsolf.entity_and_adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.otherframejiangjunling.R;

public class MoreAdapter extends BaseAdapter {
	private List<More> list;
	private LayoutInflater inflater;

	public MoreAdapter(Context context) {
		list = new ArrayList<More>();
		inflater = LayoutInflater.from(context);
	}

	public void addItem(More more) {
		list.add(more);
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
			convertView = inflater.inflate(R.layout.more_listview_item, null);
			holder = new ViewHolder();

			holder.MoreGroup = (LinearLayout) convertView
					.findViewById(R.id.more_listview_group);
			holder.MoreImage = (ImageView) convertView
					.findViewById(R.id.more_item_image);
			holder.MoreBack = (ImageView) convertView
					.findViewById(R.id.more_item_back);
			holder.MoreTitle = (TextView) convertView
					.findViewById(R.id.more_item_title);
			holder.MoreRightText = (TextView) convertView
					.findViewById(R.id.more_item_righttext);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		
		if (list.get(position).getLinerLayoutFlag()) {
			holder.MoreGroup.setVisibility(View.VISIBLE);
		} else {
			holder.MoreGroup.setVisibility(View.GONE);
		}
		
		holder.MoreImage.setImageResource(list.get(position).getMoreImage());
		holder.MoreBack.setImageResource(list.get(position).getMoreBack());
		holder.MoreTitle.setText(list.get(position).getMoreTitle());
		holder.MoreRightText.setText(list.get(position).getMoreRightText());
		return convertView;
	}

	class ViewHolder {
		LinearLayout MoreGroup;
		ImageView MoreImage;
		TextView MoreTitle;
		TextView MoreRightText;
		ImageView MoreBack;
	}
}
