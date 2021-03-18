package com.example.studentselectcource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.example.ssc.meet.MeetDao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class SelectMeetActivity extends Activity {
	ListView list;
	Button backBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.select_meet);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//设置窗体始终点亮
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//设置窗体始终点亮

		list = (ListView) findViewById(R.id.listviews);//加载list视图
		list = (ListView) findViewById(R.id.listviews);

		// 调用CourceDao查询方法进行查询
		MeetDao dao = new MeetDao(this);
		// 获取列表数据
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		listItem = dao.getAllData();

		// 生成适配器的Item和动态数组对应的元素

		SimpleAdapter listItemAdapter = new SimpleAdapter(this, listItem,// 数据源
				R.layout.list_item,// ListItem的XML实现
				// 动态数组与ImageItem对应的子项
				new String[] { "m_time" },
				// ImageItem的XML文件里面的一个ImageView,两个TextView ID
				new int[] { R.id.text });

		// 添加并且显示
		list.setAdapter(listItemAdapter);

		// 添加点击
		list.setOnItemClickListener(new OnItemClickListener() {//设置监听器

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int postion, long longs) {
				// 获得选中项的HashMap对象
				@SuppressWarnings("unchecked")
				Map<String, String> map = (Map<String, String>) list
						.getItemAtPosition(postion);
				String c_id = map.get("m_id");
				String c_name = map.get("m_time");
				
				Intent intent = new Intent(SelectMeetActivity.this,
						MeetDetailActivity.class);//实现页面跳转 从this到CourceDetailActivity.class
				/* 通过Bundle对象存储需要传递的数据 */  
				Bundle bundle = new Bundle();  //bundle键值对
				/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/  
				bundle.putString("m_id", c_id);
				bundle.putString("m_time", c_name);
				bundle.putString("from", "选择讲解");
				/*把bundle对象assign给Intent*/  
				intent.putExtras(bundle); 
				startActivity(intent);
			}
		});
		
		backBtn = (Button) findViewById(R.id.fanhui);
		backBtn.setOnClickListener(new OnClickListener() {//匿名内部类监听器
			@Override
			public void onClick(View arg0) {
				finish();
			}
		});

	}
	/**
	 * @help 返回上一个界面
	 */
	@Override
	public void onBackPressed() {
		finish();
	}
}
