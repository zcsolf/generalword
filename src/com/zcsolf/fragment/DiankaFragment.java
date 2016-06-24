package com.zcsolf.fragment;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.GridView;

import com.example.otherframejiangjunling.R;
import com.zcsolf.entity_and_adapter.Dianka;
import com.zcsolf.entity_and_adapter.DiankaAdapter;

public class DiankaFragment extends Fragment {
	GridView gview;
	RelativeLayout DiankaItem1,DiankaItem2,DianKaItem3;
	public DiankaFragment() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fragment_dianka, container,
				false);
		gview = (GridView) rootView.findViewById(R.id.dianka_gridView);
		DiankaAdapter dkAdapter = new DiankaAdapter(getActivity());
		Dianka dianka = null;
		dianka = new Dianka("50点");
		dkAdapter.addItem(dianka);
		dianka = new Dianka("100点");
		dkAdapter.addItem(dianka);
		dianka = new Dianka("500点");
		dkAdapter.addItem(dianka);
		dianka = new Dianka("1000点");
		dkAdapter.addItem(dianka);
		dianka = new Dianka("2000点");
		dkAdapter.addItem(dianka);
		dianka = new Dianka("其他点数");
		dkAdapter.addItem(dianka);
		gview.setAdapter(dkAdapter);
		gview.setSelector(new ColorDrawable(Color.TRANSPARENT));// 取消GridView中Item选中时默认的背景色

		DianKaItem3 = (RelativeLayout) rootView
				.findViewById(R.id.dianka_item3);
		DiankaItem1 = (RelativeLayout) rootView.findViewById(R.id.dianka_item1);
		DiankaItem2 = (RelativeLayout) rootView.findViewById(R.id.dianka_item2);
		final CharSequence[] dialogItem = new CharSequence[] { "新大话西游2",
				"新大话西游3", "新倩女幽魂" };
		// 专用点的点击事件
		DiankaItem1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "通用点点击", Toast.LENGTH_SHORT).show();
			}
		});
		DiankaItem2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(getActivity(), "寄售点点击", Toast.LENGTH_SHORT).show();
			}
		});
		DianKaItem3.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				AlertDialog.Builder dialog = new AlertDialog.Builder(
						getActivity()).setTitle("列表对话框").setItems(dialogItem,
						new OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								Toast.makeText(getActivity(),
										"选中了" + dialogItem[which] + "!",
										Toast.LENGTH_SHORT).show();
							}
						});
				dialog.create().show();
			}
		});
		
		return rootView;
	}

}






