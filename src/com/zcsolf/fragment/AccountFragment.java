package com.zcsolf.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.otherframejiangjunling.R;
import com.zcsolf.entity_and_adapter.AccountCenter;
import com.zcsolf.entity_and_adapter.AccountCenterAdapter;

public class AccountFragment extends Fragment{
	ListView AccountListView;
	public AccountFragment() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_account, container, false);
		AccountListView = (ListView) rootView.findViewById(R.id.account_listview);
		AccountCenterAdapter aca = new AccountCenterAdapter(getActivity());
		AccountCenter ac = null;
		ac = new AccountCenter(R.drawable.account_item_first, R.drawable.dianka_right, "账号管理","1*005@qq.com","");
		aca.addItem(ac);
		ac = new AccountCenter(R.drawable.account_item_second, R.drawable.dianka_right, "余额查询", "上次查询结果:", "0点");
		aca.addItem(ac);
		ac = new AccountCenter(R.drawable.account_item_third, R.drawable.dianka_right, "我的钱包", "管理银行卡", "");
		aca.addItem(ac);
		ac = new AccountCenter(R.drawable.account_item_fourth, R.drawable.dianka_right, "安全体检", "上次体检得分:", "77分");
		aca.addItem(ac);
		ac = new AccountCenter(R.drawable.account_item_fifth, R.drawable.dianka_right, "修改密码", "快速修改密码", "");
		aca.addItem(ac);
		ac = new AccountCenter(R.drawable.account_item_sixth, R.drawable.dianka_right, "锁定帐号", "限制账号登陆", "");
		aca.addItem(ac);
		AccountListView.setAdapter(aca);
		return rootView;
	}
	
}
