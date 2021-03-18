package com.example.studentselectcource;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


import com.example.ssc.infohandle.InsertVisitor;

public class LoginActivity extends Activity {

	private EditText user;
	private EditText password;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		user = (EditText) findViewById(R.id.ET1);
		password = (EditText) findViewById(R.id.ET2);

	}
	public void register(View v) {
		Intent intent = new Intent();
		intent.setClass(this, InsertVisitor.class);
		startActivity(intent);
		finish();}

	public void adminer(View v) {String name = user.getText().toString().trim();
		String pwd = password.getText().toString().trim();
		// 判断用户名是否为空
		if (name.equals("")) {
			errorMsg(this, "错误信息", "用户名不能为空！");
		}
		// 判断密码是否为空
		else if (pwd.equals("")) {
			errorMsg(this, "错误信息", "密码不能为空！");
		}
		// 判断用户名和密码是否正确
		else if (!(pwd.equals("admin")&& name.equals("admin"))) {
			errorMsg(this, "错误信息", "用户名或密码错误，请重新输入");
		}
		// 全部正确跳转到主菜单页面

		else {
			Intent intent = new Intent();
			intent.setClass(this, MainActivity_adminer.class);
			startActivity(intent);
			finish();
	  }}


	// 登录按钮监听
	public void load(View v) {
		String name = user.getText().toString().trim();
		String pwd = password.getText().toString().trim();
		// 判断用户名是否为空
		if (name.equals("")) {
			errorMsg(this, "错误信息", "用户名不能为空！");
		}
		// 判断密码是否为空
		else if (pwd.equals("")) {
			errorMsg(this, "错误信息", "密码不能为空！");
		}
		// 判断用户名和密码是否正确
		else if (!(pwd.equals("0000")&& name.equals("2018"))) {
		errorMsg(this, "错误信息", "用户名或密码错误，请重新输入");
		}
		// 全部正确跳转到主菜单页面

		else {
			Intent intent = new Intent();
			Bundle bundle = new Bundle();
			bundle.putString("name", "admin");
			intent.putExtras(bundle);
			intent.setClass(this, MainActivity.class);
			startActivity(intent);
			finish();
		}
	}

	// 错误消息对话框
	public void errorMsg(Context context, String title, String message) {
		AlertDialog.Builder builder = new AlertDialog.Builder(context);
		builder.setTitle(title);
		builder.setMessage(message);
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}

}