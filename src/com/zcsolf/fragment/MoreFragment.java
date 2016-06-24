package com.zcsolf.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.otherframejiangjunling.R;
import com.zcsolf.entity_and_adapter.More;
import com.zcsolf.entity_and_adapter.MoreAdapter;

public class MoreFragment extends Fragment{
	ListView lv;
	public MoreFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_more, container, false);
		lv = (ListView) rootView.findViewById(R.id.more_listview);
		MoreAdapter ma = new MoreAdapter(getActivity());
		More more;
		more = new More(R.drawable.more_item_frist, "游戏", "", R.drawable.dianka_right,true);
		ma.addItem(more);
		more = new More(R.drawable.more_item_second, "启动密码", "未开启", R.drawable.dianka_right, true);
		ma.addItem(more);
		more = new More(R.drawable.more_item_third, "查看序列号", null, R.drawable.dianka_right, false);
		ma.addItem(more);
		more = new More(R.drawable.more_item_forth, "校准时间", null,R.drawable.dianka_right, false);
		ma.addItem(more);
		more = new More(R.drawable.more_item_fifth, "设置主题", null, R.drawable.dianka_right, false);
		ma.addItem(more);
		more = new More(R.drawable.more_item_sixth, "关于", null, R.drawable.dianka_right, true);
		ma.addItem(more);
		lv.setAdapter(ma);
		return rootView;
	}
	
}	
