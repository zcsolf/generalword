package com.zcsolf.fragment;

import com.example.otherframejiangjunling.R;
import com.zcsolf.activity.son.EmailActivity;
import com.zcsolf.otherframejiangjunling.MipcaActivityCapture;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class PlaceholderFragment extends Fragment {
	private static final String SectionNumber = "section_number";
	protected static final int SCANNIN_GREQUEST_CODE = 1;
	View rootView;
	private TextView DynPass1, DynPass2, DynPass3, DynPass4, DynPass5,
			DynPass6, timeShow;
	private ProgressBar progress;
	private ImageView EmailImage; // 右上角的信封图片,里面放的listView邮件

	public PlaceholderFragment() {
		// TODO Auto-generated constructor stub
	}

	public static PlaceholderFragment newInstance(int sectionNumber) {
		Log.v("framenuber", sectionNumber + "");
		PlaceholderFragment fragment = new PlaceholderFragment();
		Bundle args = new Bundle();
		args.putInt(SectionNumber, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	int status = 0; // 记录进度条的完成度
	int randomPass[] = new int[] { 2, 3, 4, 5, 6, 7 }; // 存储动态密码
	final int msgKey = 1; // 传递显示时间的消息Key.
	final int msgKeyBar = 2; // 传递进度条更新的消息Key.
	final int msgKeyDynPass = 3; // 传递动态密码更新的消息Key.

	final Handler handler = new Handler() {
		// 接收新线程发来的消息
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			switch (msg.what) {
			case msgKey: // 更新时间的消息
				long sysTime = System.currentTimeMillis(); // 获取当前时间
				CharSequence sysTimeStr = DateFormat
						.format("hh:mm:ss", sysTime);
				timeShow.setText(sysTimeStr);
				break;
			case msgKeyBar: // 更新进度条的消息
				progress.setProgress(status);
				break;
			case msgKeyDynPass:

				 DynPass1.setText(randomPass[0]);
				 DynPass2.setText(randomPass[1]);
				 DynPass3.setText(randomPass[2]);
				 DynPass4.setText(randomPass[3]);
				 DynPass5.setText(randomPass[4]);
				 DynPass6.setText(randomPass[5]);
				break;
			default:
				break;
			}
		}

	};


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		rootView = inflater.inflate(R.layout.fragment_login, container, false);
		// int arg = getArguments().getInt(SectionNumber);

		// final int msgKey = 1; // 传递显示时间的消息Key.
		// final int msgKeyBar = 2; // 传递进度条更新的消息Key.
		// final int msgKeyDynPass = 3; // 传递动态密码更新的消息Key.

		ImageView imageSao = (ImageView) rootView
				.findViewById(R.id.loginfragment_2weimaImage);

		progress = (ProgressBar) rootView
				.findViewById(R.id.fragmentlogin_Refresh);

		EmailImage = (ImageView) rootView
				.findViewById(R.id.loginfragment_title_Image_news);
		// 点击信封图片跳转下一个Activity
		EmailImage.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(), EmailActivity.class);
				getActivity().startActivity(intent);
			}
		});
		// 显示系统时间的部分
		timeShow = (TextView) rootView.findViewById(R.id.fragmentlogin_Time);
		DynPass1 = (TextView) rootView.findViewById(R.id.Text2weima_num1);
		DynPass2 = (TextView) rootView.findViewById(R.id.Text2weima_num2);
		DynPass3 = (TextView) rootView.findViewById(R.id.Text2weima_num3);
		DynPass4 = (TextView) rootView.findViewById(R.id.Text2weima_num4);
		DynPass5 = (TextView) rootView.findViewById(R.id.Text2weima_num5);
		DynPass6 = (TextView) rootView.findViewById(R.id.Text2weima_num6);

		// 更新时间
		new Thread(new Runnable() {
			@Override
			public void run() {
				do {
					try {
						Thread.sleep(1000);
						Message msg = new Message();
						msg.what = msgKey;
						handler.sendMessage(msg);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} while (true);
			}
		}).start();

		// 计时刷新条所开的线程
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 1;; i++) {
					try {
						Thread.sleep(100);
						status += 1;
						handler.sendEmptyMessage(msgKeyBar);
						if (i == 600) {
							status = 0;
							i = 1;

						}

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}).start();

		// 更新动态密码.
		/**
		 * 扫描二维码
		 */
		imageSao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent();
				intent.setClass(getActivity(), MipcaActivityCapture.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivityForResult(intent, SCANNIN_GREQUEST_CODE);
			}
		});
		return rootView;
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	}

}
