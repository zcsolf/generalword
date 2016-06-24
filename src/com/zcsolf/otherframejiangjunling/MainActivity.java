package com.zcsolf.otherframejiangjunling;


import java.util.ArrayList;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.example.otherframejiangjunling.R;
import com.zcsolf.ViewPagerAdapter.SectionsPagerAdapter;
import com.zcsolf.fragment.AccountFragment;
import com.zcsolf.fragment.DiankaFragment;
import com.zcsolf.fragment.GameFriendFragment;
import com.zcsolf.fragment.MoreFragment;
import com.zcsolf.fragment.PlaceholderFragment;
import com.zcsolf.music.BackgroundMusic;

public class MainActivity extends Activity implements OnItemClickListener,
		OnClickListener {
	SectionsPagerAdapter spa;
	ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	ViewPager viewPager;
	GridView TabGridView;
	private RelativeLayout rlLogin, rlDianka, rlAccount, rlGame, rlMore;
	// 底部tab的image
	private ImageView LoginImage, DiankaImage, AccountImage, GameImage,
			MoreImage;
	// 底部tab的text
	private TextView LoginText, DiankaText, AccountText, GameText, MoreText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main1);

		initViewPager();

		viewPager
				.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
					@Override
					public void onPageSelected(int position) {
						switch (position) {
						case 0:
							ClickTabLayout1();
							break;
						case 1:
							ClickTabLayout2();
							break;
						case 2:
							ClickTabLayout3();
							break;
						case 3:
							ClickTabLayout4();
							break;
						case 4:
							ClickTabLayout5();
							break;

						default:
							break;
						}
					}
				});
		initView();
		// initTabView();
		// 设置背景音乐
		BackgroundMusic bgm = new BackgroundMusic(MainActivity.this);
		bgm.createMediaPlayerFromAssets("changancheng.mp3").start();
//		MediaPlayer mediaPlayer = new MediaPlayer();
//		AssetFileDescriptor afd;
//		try {
//			afd = getAssets().openFd("changancheng.mp3");
//			mediaPlayer.setDataSource(afd.getFileDescriptor());
//			mediaPlayer.prepare();
//			mediaPlayer.start();
//
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}

	/**
	 * 初始化viewPager
	 */
	public void initViewPager() {
		Fragment fragment = PlaceholderFragment.newInstance(1);
		// 将fragment添加进列表
		fragments.add(fragment);
		fragment = new DiankaFragment();
		fragments.add(fragment);
		fragment = new AccountFragment();
		fragments.add(fragment);
		fragment = new GameFriendFragment();
		fragments.add(fragment);
		fragment = new MoreFragment();
		fragments.add(fragment);

		spa = new SectionsPagerAdapter(MainActivity.this, getFragmentManager(),
				fragments);
		viewPager = (ViewPager) findViewById(R.id.pager);
		viewPager.setAdapter(spa);
	}

	/**
	 * 初始化底部Tab(采用gridView布局底部Tab时)
	 */
	/*
	 * private void initTabView() { TabAdapter adapter = new
	 * TabAdapter(MainActivity.this);
	 * 
	 * User1 user1 = new User1(R.drawable.icon_login_normal, "登录");
	 * adapter.addItem(user1); User1 user2 = new
	 * User1(R.drawable.icon_dianka_normal, "点卡充值"); adapter.addItem(user2);
	 * User1 user3 = new User1(R.drawable.icon_account_normal, "账户中心");
	 * adapter.addItem(user3); User1 user4 = new
	 * User1(R.drawable.icon_game_normal, "游戏助手"); adapter.addItem(user4); User1
	 * user5 = new User1(R.drawable.icon_more_normal, "更多");
	 * adapter.addItem(user5);
	 * 
	 * TabGridView = (GridView) findViewById(R.id.frame_tab_gridview);
	 * TabGridView.setAdapter(adapter);
	 * TabGridView.setOnItemClickListener(this); // 给底部用GridView打造的Tab绑定监听器 }
	 */

	// 此Activty实现OnItemClickListener接口中的方法.
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		switch (position) {
		case 0:
			viewPager.setCurrentItem(0);
			break;
		case 1:
			viewPager.setCurrentItem(1);
			break;
		case 2:
			viewPager.setCurrentItem(2);
			break;
		case 3:
			viewPager.setCurrentItem(3);
			break;
		case 4:
			viewPager.setCurrentItem(4);
			break;
		default:
			break;
		}

	}

	/*
	 * 点击底部第一个Tab
	 */
	public void ClickTabLayout1() {
		LoginImage.setImageResource(R.drawable.icon_login_pressed);
		LoginText
				.setTextColor(getResources().getColor(R.color.bottomtab_press));
		DiankaImage.setImageResource(R.drawable.icon_dianka_normal);
		DiankaText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		AccountImage.setImageResource(R.drawable.icon_account_normal);
		AccountText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		GameImage.setImageResource(R.drawable.icon_game_normal);
		GameText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
		MoreImage.setImageResource(R.drawable.icon_more_normal);
		MoreText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
	}

	/*
	 * 点击底部第二个Tab
	 */
	public void ClickTabLayout2() {
		LoginImage.setImageResource(R.drawable.icon_login_normal);
		LoginText.setTextColor(getResources()
				.getColor(R.color.bottomtab_normal));
		DiankaImage.setImageResource(R.drawable.icon_dianka_pressed);
		DiankaText.setTextColor(getResources()
				.getColor(R.color.bottomtab_press));
		AccountImage.setImageResource(R.drawable.icon_account_normal);
		AccountText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		GameImage.setImageResource(R.drawable.icon_game_normal);
		GameText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
		MoreImage.setImageResource(R.drawable.icon_more_normal);
		MoreText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
	}

	/*
	 * 点击底部第三个Tab
	 */
	public void ClickTabLayout3() {
		LoginImage.setImageResource(R.drawable.icon_login_normal);
		LoginText.setTextColor(getResources()
				.getColor(R.color.bottomtab_normal));
		DiankaImage.setImageResource(R.drawable.icon_dianka_normal);
		DiankaText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		AccountImage.setImageResource(R.drawable.icon_account_pressed);
		AccountText.setTextColor(getResources().getColor(
				R.color.bottomtab_press));
		GameImage.setImageResource(R.drawable.icon_game_normal);
		GameText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
		MoreImage.setImageResource(R.drawable.icon_more_normal);
		MoreText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
	}

	/*
	 * 点击底部第四个Tab
	 */
	public void ClickTabLayout4() {
		LoginImage.setImageResource(R.drawable.icon_login_normal);
		LoginText.setTextColor(getResources()
				.getColor(R.color.bottomtab_normal));
		DiankaImage.setImageResource(R.drawable.icon_dianka_normal);
		DiankaText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		AccountImage.setImageResource(R.drawable.icon_account_normal);
		AccountText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		GameImage.setImageResource(R.drawable.icon_game_pressed);
		GameText.setTextColor(getResources().getColor(R.color.bottomtab_press));
		MoreImage.setImageResource(R.drawable.icon_more_normal);
		MoreText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
	}

	/*
	 * 点击底部第五个Tab
	 */
	public void ClickTabLayout5() {
		LoginImage.setImageResource(R.drawable.icon_login_normal);
		LoginText.setTextColor(getResources()
				.getColor(R.color.bottomtab_normal));
		DiankaImage.setImageResource(R.drawable.icon_dianka_normal);
		DiankaText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		AccountImage.setImageResource(R.drawable.icon_account_normal);
		AccountText.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		GameImage.setImageResource(R.drawable.icon_game_normal);
		GameText.setTextColor(getResources().getColor(R.color.bottomtab_normal));
		MoreImage.setImageResource(R.drawable.icon_more_pressed);
		MoreText.setTextColor(getResources().getColor(R.color.bottomtab_press));
	}

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		switch (view.getId()) {
		case R.id.rLayout_loginFrame:
			ClickTabLayout1();
			viewPager.setCurrentItem(0);
			break;
		case R.id.rLayout_diankaFrame:
			ClickTabLayout2();
			viewPager.setCurrentItem(1);
			break;
		case R.id.rLayout_accountFrame:
			ClickTabLayout3();
			viewPager.setCurrentItem(2);
			break;
		case R.id.rLayout_GameFrame:
			ClickTabLayout4();
			viewPager.setCurrentItem(3);
			break;
		case R.id.rLayout_MoreFrame:
			ClickTabLayout5();
			viewPager.setCurrentItem(4);
			break;
		default:
			break;
		}
	}

	// 定义初始化底部Tab的方法
	public void initView() {
		rlLogin = (RelativeLayout) findViewById(R.id.rLayout_loginFrame);
		rlDianka = (RelativeLayout) findViewById(R.id.rLayout_diankaFrame);
		rlAccount = (RelativeLayout) findViewById(R.id.rLayout_accountFrame);
		rlGame = (RelativeLayout) findViewById(R.id.rLayout_GameFrame);
		rlMore = (RelativeLayout) findViewById(R.id.rLayout_MoreFrame);
		// 给每个底部tab绑定监听器
		rlLogin.setOnClickListener(this);
		rlDianka.setOnClickListener(this);
		rlAccount.setOnClickListener(this);
		rlGame.setOnClickListener(this);
		rlMore.setOnClickListener(this);

		LoginImage = (ImageView) findViewById(R.id.rLayout_loginImage);
		DiankaImage = (ImageView) findViewById(R.id.rLayout_diankaImage);
		AccountImage = (ImageView) findViewById(R.id.rLayout_accountImage);
		GameImage = (ImageView) findViewById(R.id.rLayout_GameFriendImage);
		MoreImage = (ImageView) findViewById(R.id.rLayout_MoreImage);

		LoginText = (TextView) findViewById(R.id.rLayout_loginText);
		DiankaText = (TextView) findViewById(R.id.rLayout_diankaText);
		AccountText = (TextView) findViewById(R.id.rLayout_accountText);
		GameText = (TextView) findViewById(R.id.rLayout_GameFriendText);
		MoreText = (TextView) findViewById(R.id.rLayout_MoreText);

		ClickTabLayout1();
	}

}
