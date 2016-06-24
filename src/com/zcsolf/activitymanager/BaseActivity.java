package com.zcsolf.activitymanager;

import android.app.Activity;
import android.os.Bundle;

/**
 * 建立一个此项目中所有的.
 * @author zcsolf
 *
 */
public class BaseActivity extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		ActivityCollector.addActivity(this);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ActivityCollector.removeActivity(this);
	}
}
