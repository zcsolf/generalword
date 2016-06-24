package com.zcsolf.ViewPagerAdapter;

import java.util.ArrayList;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v13.app.FragmentPagerAdapter;
import android.view.ViewGroup;

/**
 * 
 * @author zcsolf 这是写viewpager适配器内容的。
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {
	private ArrayList<Fragment> fragmentsList;
	private FragmentManager fm; // 声明一个Fragment管理者
	private Context context;

	public SectionsPagerAdapter(Context context, FragmentManager fm,
			ArrayList<Fragment> fragmentsList) {
		super(fm);
		this.fragmentsList = fragmentsList;
		this.fm = fm;
		this.context = context;
	}

	@Override
	public Fragment getItem(int position) {
		// TODO Auto-generated method stub
		return fragmentsList.get(position);
	}

	/**
	 * viewpager中组件的数量
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return fragmentsList.size();
	}

	/**
	 * 每次滑动后生成的组件
	 */
	@Override
	public Object instantiateItem(ViewGroup container, final int position) {
		// TODO Auto-generated method stub
		Object obj = super.instantiateItem(container, position);
		return obj;
	}

	/**
	 * 当数据改变时想要动态的更新ViewPager的显示时，如果有用过BaseAdapter重写过的一般都知道可以直接调用adapter.
	 * notifyDataSetChanged
	 * ()来动态的更新数据的显示；但是在这里调用notifyDataSetChanged却发现ViewPager并没有进行相应的数据更新
	 * （具体原因是什么现在还不是很理解，可以的话有空查看一下源代码）；重写getItemPosition让它返回POSITOIN_
	 * NONE;这样做的目的是notifyDataSetChanged时返回空
	 * ，这样就会从数据重新填充，再外部更新数据然后调用n otifyDataSetChanged更新就达到了目的了。
	 */
	@Override
	public int getItemPosition(Object object) {
		// TODO Auto-generated method stub
		return POSITION_NONE;
	}

}
