package com.zcsolf.fragment;

import android.app.Fragment;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.otherframejiangjunling.R;
import com.zcsolf.entity_and_adapter.GameFriend;
import com.zcsolf.entity_and_adapter.GameFriendAdapter;

public class GameFriendFragment extends Fragment{
	private GridView gv;
	public GameFriendFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_gamefriend, container, false);
		gv = (GridView) rootView.findViewById(R.id.gamefriend_gridview);
		GameFriendAdapter gfa = new GameFriendAdapter(getActivity());
		GameFriend gf = null;
		gf = new GameFriend(R.drawable.gamefriend_item_first, "游戏精灵");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_second, "工具箱");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_third, "游戏动态");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_fourth, "游戏论坛");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_fifth, "百宝箱");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_sixth, "角色查询");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_seventh, "CC直播");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_eighth, "活动闹钟");
		gfa.addItem(gf);
		gf = new GameFriend(R.drawable.gamefriend_item_nineth, "角色下线");
		gfa.addItem(gf);
		gv.setAdapter(gfa);
		
		gv.setSelector(new ColorDrawable(Color.TRANSPARENT));		//取消Item点击效果
		gv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				switch (position) {
				case 0 :
					Toast.makeText(getActivity(), "游戏精灵", Toast.LENGTH_SHORT).show();
					break;
				case 1:
					Toast.makeText(getActivity(), "工具箱", Toast.LENGTH_SHORT).show();
					break;
				case 2:
					Toast.makeText(getActivity(), "游戏动态", Toast.LENGTH_SHORT).show();
					break;
				case 3:
					Toast.makeText(getActivity(), "游戏论坛", Toast.LENGTH_SHORT).show();
					break;
				case 4:
					Toast.makeText(getActivity(), "百宝箱", Toast.LENGTH_SHORT).show();
					break;
				case 5:
					Toast.makeText(getActivity(), "角色查询", Toast.LENGTH_SHORT).show();
					break;
				case 6:
					Toast.makeText(getActivity(), "CC直播", Toast.LENGTH_SHORT).show();
					break;
				case 7:
					Toast.makeText(getActivity(), "活动闹钟", Toast.LENGTH_SHORT).show();
					break;
				case 8:
					Toast.makeText(getActivity(), "角色下线", Toast.LENGTH_SHORT).show();
					break;
				default:
					break;
				}
			}
		});
		return rootView;
	}
	
}
