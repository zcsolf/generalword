package com.zcsolf.entity_and_adapter;

import java.io.File;
import java.util.List;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.otherframejiangjunling.R;
import com.zcsolf.entity_from_service.Contact;
import com.zcsolf.getimage_from_service.ContactService;

/**
 * 首页(即第一个fragment)中的右上角信封图片跳转的Activity中ListView的Adapter
 * 
 * @author zcsolf 自定义Adapter
 */
public class EmailAdapter extends BaseAdapter {
	private List<Contact> data; // 缓存数据
	private int listViewItem; // 条目ID,即ListView的Item布局文件在R文件中的位置
	private File cache; // 缓存文件
	LayoutInflater inflater;

	// public EmailAdapter(Context context, List<Contact> data, int
	// listViewItem,
	// File cache,LayoutInflater inflater) {
	// super();
	// this.data = data;
	// this.listViewItem = listViewItem;
	// this.cache = cache;
	// inflater = (LayoutInflater) context
	// .getSystemService(Context.LAYOUT_INFLATER_SERVICE);// 获取布局填充服务
	// }
	public EmailAdapter(Context context, List<Contact> data, int listViewItem,
			File cache) {
		super();
		this.data = data;
		this.listViewItem = listViewItem;
		this.cache = cache;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return data.size();
	}

	/**
	 * 根据数据索引得到集合所对应的数据
	 */
	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	/**
	 * 当listView每显示一个条目的时候,都会调用这个方法
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ImageView image = null;
		TextView title = null;
		TextView content = null;
		TextView date = null;

		if (convertView == null) {
			convertView = inflater.inflate(listViewItem, null); // 获取条目的view对象
			image = (ImageView) convertView.findViewById(R.id.email_item_Image);
			title = (TextView) convertView.findViewById(R.id.email_item_title);
			content = (TextView) convertView
					.findViewById(R.id.email_item_content);
			date = (TextView) convertView.findViewById(R.id.email_item_data);
			convertView.setTag(new ViewHolder(image, title, content, date));
		} else {
			ViewHolder holder = (ViewHolder) convertView.getTag();
			image = holder.image;
			title = holder.title;
			content = holder.content;
			date = holder.date;
		}

		// 待测试 : 如果实体类是private封装后，用getXXX()来调用
		Contact contact = data.get(position);
		title.setText(contact.title);
		content.setText(contact.content);
		date.setText(contact.date);

		asyncImageLoad(image, contact.image); // 异步加载图片
		return convertView;
	}

	private void asyncImageLoad(ImageView image, String path) {
		AsyncImageTask asyncImageTask = new AsyncImageTask(image);
		asyncImageTask.execute(path);
	}

	/**
	 * 使用AsyncTask异步加载图片
	 * 
	 * @author zcsolf
	 * AsyncTask<Params,Progress,Result>是抽象类,定义了三种泛型类型。
	 * Params：启动任务执行的输入参数的类型
	 * Progress:后台任务完成的进度值类型。
	 * Result:后台执行任务完成后返回结果的类型
	 */
	private final class AsyncImageTask extends AsyncTask<String, Integer, Uri> {
		private ImageView image;

		public AsyncImageTask(ImageView image) {
			this.image = image;
		}

		/**
		 * 继承AsyncTask必须实现的方法 耗时操作都在子线程中执行
		 */
		@Override
		protected Uri doInBackground(String... params) {
			try {
				return ContactService.getImage(params[0], cache);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * 这个方法会在后台任务开始执行之前调用，用于进行一些界面上的初始化操作，比 如显示一个进度条对话框等。
		 */
		@Override
		protected void onPostExecute(Uri result) {
			if (result != null && image != null) {
				image.setImageURI(result);
			}
		}

	}

	private final class ViewHolder {
		ImageView image;
		TextView title, content, date;
		
		public ViewHolder(ImageView image, TextView title, TextView content,
				TextView date) {
			this.image = image;
			this.title = title;
			this.content = content;
			this.date = date;
		}
	}
}
