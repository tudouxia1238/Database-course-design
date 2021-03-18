package com.example.studentselectcource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.ssc.meet.MeetDao;

public class ShowMeetActivity extends Activity {
	ListView list;
	Button backBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.show_meet);//加载布局文件
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//设置窗体始终点亮
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
				WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

		list = (ListView) findViewById(R.id.listviews);
		list = (ListView) findViewById(R.id.listviews);
		//list.setDivider(null);

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
		list.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view,
					int postion, long longs) {
				// 获得选中项的HashMap对象
				@SuppressWarnings("unchecked")
				Map<String, String> map = (Map<String, String>) list
						.getItemAtPosition(postion);
				String c_id = map.get("m_id");
				String c_name = map.get("m_time");
				
				Intent intent = new Intent(ShowMeetActivity.this,
						MeetDetailActivity.class);
				//传递数据
				Bundle bundle = new Bundle();  
				/*字符、字符串、布尔、字节数组、浮点数等等，都可以传*/  
				bundle.putString("m_id", c_id);
				bundle.putString("m_time", c_name);
				bundle.putString("from", "查看讲解");
				/*把bundle对象assign给Intent*/  
				intent.putExtras(bundle); 
				startActivity(intent);
			}
		});
		
		backBtn = (Button) findViewById(R.id.fanhui);
		backBtn.setOnClickListener(new OnClickListener() {//匿名内部类
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
