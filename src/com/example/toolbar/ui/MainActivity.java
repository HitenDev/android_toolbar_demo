package com.example.toolbar.ui;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.toolbar.R;
import com.example.toolbar.R.color;
import com.example.toolbar.R.drawable;
import com.example.toolbar.R.id;
import com.example.toolbar.R.layout;
import com.example.toolbar.R.string;
import com.example.toolbar.fragment.RecommendFragment;
import com.example.toolbar.fragment.SuperAwesomeCardFragment;
import com.example.toolbar.view.PageIndicator;
import com.example.toolbar.view.PageIndicator.Callback;
/**
 * 主界面
 * @author putaoji
 *
 */
public class MainActivity extends ActionBarActivity implements OnClickListener {
	private DrawerLayout mDrawerLayout;
	private ActionBarDrawerToggle mDrawerToggle;
	private ViewPager mViewPager;
	private Toolbar mToolbar;
	private PageIndicator page_indicator;
	private ImageView home_switch_dnamic_pic;
	private ImageView home_switch_pubar_pic;
	private ImageView home_switch_tuijian_pic;
	private TextView home_switch_dnamic_text;
	private TextView home_switch_pubar_text;
	private TextView home_switch_tuijian_text;
	private View home_switch_dnamic;
	private View home_switch_tuijian;
	private View home_switch_pubar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initViews();
	}
	private void initViews() {
		mToolbar = (Toolbar) findViewById(R.id.toolbar);
		mToolbar.setTitle("");// 标题的文字需在setSupportActionBar之前，不然会无效
		setSupportActionBar(mToolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		/* findView */
		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
		home_switch_dnamic = findViewById(R.id.home_switch_dnamic);
		home_switch_tuijian = findViewById(R.id.home_switch_tuijian);
		home_switch_pubar = findViewById(R.id.home_switch_pubar);
		home_switch_dnamic_pic = (ImageView) findViewById(R.id.home_switch_dnamic_pic);
		home_switch_tuijian_pic = (ImageView) findViewById(R.id.home_switch_tuijian_pic);
		home_switch_pubar_pic = (ImageView) findViewById(R.id.home_switch_pubar_pic);
		home_switch_dnamic_text = (TextView) findViewById(R.id.home_switch_dnamic_text);
		home_switch_tuijian_text = (TextView) findViewById(R.id.home_switch_tuijian_text);
		home_switch_pubar_text = (TextView) findViewById(R.id.home_switch_pubar_text);
		mViewPager = (ViewPager) findViewById(R.id.pager);
		// 侧滑和ToolBar绑定
		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				mToolbar, R.string.drawer_open, R.string.drawer_close);
		mDrawerToggle.syncState();
		mDrawerLayout.setDrawerListener(mDrawerToggle);
		// 设置指示点击事件
		home_switch_dnamic.setOnClickListener(this);
		home_switch_tuijian.setOnClickListener(this);
		home_switch_pubar.setOnClickListener(this);
		// ViewPager和指示器关联
		mViewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
		mViewPager.setCurrentItem(1);
		page_indicator = (PageIndicator) findViewById(R.id.page_indicator);
		page_indicator.setColor(getResources().getColor(
				R.color.applicationMainColor));
		page_indicator.setViewPager(mViewPager);
		page_indicator.getPosition(new Callback() {
			@Override
			public void onPageChanged(int position) {
				switchColor(position);
			}
		});
	}
	/**
	 * ViewPager点击滑动事件触发
	 * 
	 * @param position
	 */
	private void switchColor(int position) {
		resetColor();
		switch (position) {
		case 0:
			home_switch_dnamic_pic.setImageResource(R.drawable.dnamic_p);
			home_switch_dnamic_text.setTextColor(getResources().getColor(
					R.color.applicationMainColor));
			break;
		case 1:
			home_switch_tuijian_text.setTextColor(getResources().getColor(
					R.color.applicationMainColor));
			home_switch_tuijian_pic.setImageResource(R.drawable.tuijian_p);
			break;
		case 2:
			home_switch_pubar_pic.setImageResource(R.drawable.pubar_p);
			home_switch_pubar_text.setTextColor(getResources().getColor(
					R.color.applicationMainColor));
			break;
		default:
			break;
		}
	}
	// 更新前先还原颜色
	private void resetColor() {
		home_switch_dnamic_pic.setImageResource(R.drawable.dnamic_n);
		home_switch_pubar_pic.setImageResource(R.drawable.puba_n);
		home_switch_tuijian_pic.setImageResource(R.drawable.tuijian_n);
		home_switch_dnamic_text.setTextColor(Color.parseColor("#000000"));
		home_switch_pubar_text.setTextColor(Color.parseColor("#000000"));
		home_switch_tuijian_text.setTextColor(Color.parseColor("#000000"));
	}

	/* ***************FragmentPagerAdapter***************** */
	public class MyPagerAdapter extends FragmentPagerAdapter {


		public MyPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public CharSequence getPageTitle(int position) {
			return position+"";
		}

		@Override
		public int getCount() {
			return 3;
		}

		@Override
		public Fragment getItem(int position) {
			if(position==1){
				RecommendFragment fragment = new RecommendFragment();
				return fragment;
			}else
			return SuperAwesomeCardFragment.newInstance(position);
		}
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.home_switch_dnamic:
			mViewPager.setCurrentItem(0);
			break;
		case R.id.home_switch_tuijian:
			mViewPager.setCurrentItem(1);
			break;
		case R.id.home_switch_pubar:
			mViewPager.setCurrentItem(2);
			break;
		default:
			break;
		}
	}
	public void openUserInfo(View v){
		startActivity(new Intent(this, UserInfoActivity.class));
	}
	public void openSetting(View v){
		startActivity(new Intent(this, SettingActivity.class));
	}
	
}
