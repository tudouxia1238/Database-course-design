package com.example.studentselectcource;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ShowToast")
public class MainActivity extends Activity implements OnClickListener {
	private TextView title;
	private Button show_cource, show_teacher, my_cource, select_cource,info_handle_btn;
	private long firstTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		/*
		 * 用户显示
		 */
		Bundle bundle = getIntent().getExtras();
		String name = bundle.getString("name");
		title = (TextView) findViewById(R.id.home_title);
		title.setText("欢迎您进入系统^_^");

		show_cource = (Button) findViewById(R.id.show_cource);
		show_teacher = (Button) findViewById(R.id.show_teacher);
		my_cource = (Button) findViewById(R.id.my_cource);
		select_cource = (Button) findViewById(R.id.select_cource);


		show_cource.setOnClickListener(this);
		show_teacher.setOnClickListener(this);
		my_cource.setOnClickListener(this);
		select_cource.setOnClickListener(this);
		//info_handle_btn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		try {
			Intent intent = null;
			switch (v.getId()) {
			//查看課程
			case R.id.show_cource:
				intent = new Intent(this, ShowMeetActivity.class);
				break;
			//查看老師
			case R.id.show_teacher:
				intent = new Intent(this, ShowVisitorActivity.class);
				break;
			//我的課程
			case R.id.my_cource:
				intent = new Intent(this, MyMeetActivity.class);
				break;
			//立即選課
			case R.id.select_cource:
				intent = new Intent(this, SelectMeetActivity.class);
				break;

			}
			startActivity(intent);
		} catch (Exception e) {
			Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
		}
	}

	@Override
	public boolean onKeyUp(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			long secondTime = System.currentTimeMillis();
			if (secondTime - firstTime > 10000) {// 如果两次按键时间间隔大于800毫秒，则不退出
				Toast.makeText(MainActivity.this, "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				firstTime = secondTime;// 更新firstTime
				return true;
			} else {
				System.exit(0);// 否则退出程序
			}
		}
		return super.onKeyUp(keyCode, event);
	}

}
