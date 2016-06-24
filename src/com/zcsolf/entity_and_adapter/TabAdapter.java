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
/**
 * 
 * @author zcsolf
 * 这是底部tab的自定义 适配器
 */
public class TabAdapter extends BaseAdapter {
	private List<User1> list;
	private LayoutInflater inflater;
	public TabAdapter(Context context) {
		list = new ArrayList<User1>();
		inflater = LayoutInflater.from(context);
	}
	public void addItem(User1 user){
		list.add(user);
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
		ViewHolder holder = null;
		if(convertView == null){
			convertView =inflater.inflate(R.layout.tab_item, null);
			holder = new ViewHolder();
			
			holder.image = (ImageView) convertView.findViewById(R.id.tabitem_image);
			holder.tabText = (TextView) convertView.findViewById(R.id.tabitem_text);
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.image.setImageResource(list.get(position).getTabImage());
		holder.tabText.setText(list.get(position).getTabName());
		return convertView;
	}
	public class ViewHolder{
		ImageView image;
		TextView tabText;
	}
}
