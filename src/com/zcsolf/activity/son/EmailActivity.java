package com.zcsolf.activity.son;

import java.io.File;
import java.util.List;

import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otherframejiangjunling.R;
import com.zcsolf.activitymanager.BaseActivity;
import com.zcsolf.entity_and_adapter.EmailAdapter;
import com.zcsolf.entity_from_service.Contact;
import com.zcsolf.getimage_from_service.ContactService;

/**
 * PlaceholderFragment的email(消息中心)的Activity
 * 
 * @author zcsolf
 * 
 */
public class EmailActivity extends BaseActivity {
	ListView listView;
	File cache; // 缓存文件
	TextView AllNews; // 所有消息,点击弹出菜单
	PopupMenu popMenu = null; // 声明一个弹出菜单
	Handler handler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			listView.setAdapter(new EmailAdapter(EmailActivity.this,
					(List<Contact>) msg.obj, R.layout.email_listview_item,
					cache));
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.email_activity);
		listView = (ListView) findViewById(R.id.email_listView);
		AllNews = (TextView) findViewById(R.id.email_title_allnews);
		cache = new File(Environment.getExternalStorageDirectory(), "cache");// 实例化缓存

		if (!cache.exists()) {
			cache.mkdirs();// 如果文件不存在，则创建
		}

		new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					List<Contact> data = ContactService.getContacts();
					// 通过handler来发送消息
					handler.sendMessage(handler.obtainMessage(22, data)); // Debug
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		}).start();

		/**
		 * 点击"所有消息"弹出菜单.
		 */
		AllNews.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				popMenu = new PopupMenu(EmailActivity.this, AllNews);
				// 将R.menu中的菜单资源加载到popMenu菜单中
				getMenuInflater().inflate(R.menu.allnews, popMenu.getMenu());
				// 为popMenu菜单的菜单项单击事件绑定监听器
				popMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem item) {
						switch (item.getItemId()) {
						case R.id.email_title_allnews:
							popMenu.dismiss();
							break;
							
						default:
							Toast.makeText(EmailActivity.this,
									"点击了" + item.getTitle() + "项",
									Toast.LENGTH_SHORT).show();
							break;
						}
						return true;
					}
				});
				popMenu.show();
			}
		});
	}

	/**
	 * 释放缓存
	 */
	@Override
	protected void onDestroy() {
		for (File file : cache.listFiles()) {
			file.delete();
		}
		cache.delete();
		super.onDestroy();
	}

}
