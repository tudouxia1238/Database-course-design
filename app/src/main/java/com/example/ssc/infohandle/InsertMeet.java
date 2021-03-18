package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.meet.Meet;
import com.example.ssc.meet.MeetDao;
import com.example.studentselectcource.R;

public class InsertMeet extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText courceinsertET1;//定义EditText
	private EditText courceinsertET2;
	private EditText courceinsertET3;
	private EditText courceinsertET4;
	private EditText courceinsertET5;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.insert_meet);//加载布局文件
		/*
		 * 初始化EditText
		 */
		courceinsertET1 = (EditText) findViewById(R.id.courceinsertET1);//初始化编辑文本框通过id查找
		courceinsertET2 = (EditText) findViewById(R.id.courceinsertET2);
		courceinsertET3 = (EditText) findViewById(R.id.courceinsertET3);
		courceinsertET4 = (EditText) findViewById(R.id.courceinsertET4);
		courceinsertET5 = (EditText) findViewById(R.id.courceinsertET5);
	}

	/*
	 * 提交按钮监听
	 */
	public void meetInsertLoad(View v) {
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = courceinsertET1.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {//判断输入的文本是否为空
			id = Integer.parseInt(str_id);
		}
		String meetTime = courceinsertET2.getText().toString().trim();
		String academy = courceinsertET3.getText().toString().trim();
		Integer people= Integer.parseInt(courceinsertET4.getText().toString().trim());
		String grade = courceinsertET5.getText().toString().trim();
		// 封装成课程对象
		Meet meet = new Meet(id, meetTime, academy, people, grade);

		// 调用courceDao插入方法进行插入
		MeetDao dao = new MeetDao(this);
		dao.insert(meet);

		/*
		 * 弹出对话框提示插入成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功插入讲解信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}

}