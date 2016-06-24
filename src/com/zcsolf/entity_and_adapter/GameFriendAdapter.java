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
 * 自定义GameFriend中的gridview的适配器
 */
public class GameFriendAdapter extends BaseAdapter {
	private List<GameFriend> list;
	private LayoutInflater inflater;
	
	/**
	 * 初始化GameFriendAdapter
	 * @param context:上下文
	 */
	public GameFriendAdapter(Context context){
		list = new ArrayList<GameFriend>();
		inflater = LayoutInflater.from(context);
	}
	public void addItem(GameFriend gamefriend){
		list.add(gamefriend);
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
		if(convertView == null){
			convertView = inflater.inflate(R.layout.gamefriend_gridview_item, null);
			holder = new ViewHolder();
			
			holder.GameFriend_Image = (ImageView) convertView.findViewById(R.id.gamefriend_item_image);
			holder.GameFriend_Text = (TextView) convertView.findViewById(R.id.gamefriend_item_text);
			
			convertView.setTag(holder);
		}else{
			holder = (ViewHolder) convertView.getTag();
		}
		holder.GameFriend_Image.setImageResource(list.get(position).getGameFriendImage());
		holder.GameFriend_Text.setText(list.get(position).getGameFriendText());
		return convertView;
	}
	public class ViewHolder{
		ImageView GameFriend_Image;
		TextView GameFriend_Text;
	}
}
