package com.zcsolf.activitymanager;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * 建立一个Activity的集合类.方便管理activity
 * 
 * @author zcsolf
 * 
 */
public class ActivityCollector {
	public static List<Activity> activities = new ArrayList<Activity>();

	/**
	 * 静态方法添加activity
	 * 
	 * @param activity
	 */
	public static void addActivity(Activity activity) {
		activities.add(activity);
	}

	public static void removeActivity(Activity activity) {
		activities.remove(activity);
	}
	
	/**
	 * 随时退出程序时调用此方法。
	 */
	public static void finishAll() {
		for (Activity activity : activities) {
			if (!activity.isFinishing()) {
				activity.finish();
			}
		}
	}
}
