package com.example.toolbar.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.toolbar.R;

public abstract class BaseActivity extends Activity {
	protected ImageView iv_back;// 返回键
	protected TextView tv_title;// 标题
	protected LinearLayout ll_content;// 内容
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		iv_back = (ImageView) findViewById(R.id.iv_back);
		tv_title = (TextView) findViewById(R.id.tv_title);
		ll_content = (LinearLayout) findViewById(R.id.ll_content);
		View view = View.inflate(this, setView(), null);
		view.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT, 1));
		ll_content.addView(view);
		tv_title.setText(setTitle());
	}
		
	/**
	 * 返回按钮的监听
	 * 
	 * @param view
	 */
	public void back(View view) {
		onBackPressed();
	}
	/**
	 * 设置title
	 * @return
	 */
	protected abstract String setTitle();
	/**
	 * 设置填充的布局ID
	 * @return
	 */
	protected abstract int setView();
}
