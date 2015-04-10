package com.example.toolbar.ui;

import android.content.Intent;
/**
 * 登陆界面
 */
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.toolbar.R;
public class LoginActivity extends BaseActivity{
private EditText et_username;
private EditText et_password;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	initView();
}
	private void initView() {
		et_username = (EditText)findViewById(R.id.et_username);
		et_password = (EditText)findViewById(R.id.et_password);
		
}
	@Override
	protected int setView() {
		// TODO Auto-generated method stub
		return R.layout.activity_login;
	}
	@Override
	protected String setTitle() {
		// TODO Auto-generated method stub
		return "登陆";
	}
	/**
	 * 注册按钮点击事件
	 * @param v
	 */
	public void register(View v){
		startActivity(new Intent(this, RegisterActivity.class));
	}
	/**
	 * 登陆按钮点击事件
	 * @param v
	 */
	public void login(View v){
		startActivity(new Intent(this, MainActivity.class));
		finish();
	}
	/**
	 * 找回密码按钮点击事件
	 * @param v
	 */
	public void findPwd(View v){
		startActivity(new Intent(this,FindPwdActivity.class));
	}
}
