package com.zcsolf.project.service;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

/**
 * 所有的服务组件都写在com.zcsolf.project.service包中
 * 
 * @author zcsolf
 * 
 */
public class MyService extends Service {

	
	private MyBinder MBinder = null;
	
	class MyBinder extends Binder{
		
		public void askSetting(Context context){
			
		}
	}
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 在每次创建服务的时候调用
	 */
	@Override
	public void onCreate() {

		super.onCreate();
	}
	
	/**
	 * 在每次启动服务的时候调用,如果我们希望服务一旦启动就立刻去执行某个动作，就可以将逻辑写在 onStartCommand()方法里。
	 */
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Log.e(">>>>>>>>", "onStartCommand中执行的线程");
			}
		}).start();
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}
}
