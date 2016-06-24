package com.zcsolf.otherframejiangjunling;

import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

import com.example.otherframejiangjunling.R;
import com.zcsolf.activitymanager.BaseActivity;

public class WelcomeActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.welcome_activity);

		final Intent intent = new Intent(WelcomeActivity.this,
				MainActivity.class);

		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				startActivity(intent);
			}
		};
		timer.schedule(timerTask, 2000);
	}
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		finish();
	}

}
