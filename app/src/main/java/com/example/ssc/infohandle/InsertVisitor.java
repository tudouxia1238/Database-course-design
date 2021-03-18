package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.visitor.Visitor;
import com.example.ssc.visitor.VisitorDao;
import com.example.studentselectcource.R;

public class InsertVisitor extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText teainsertET1;
	private EditText teainsertET2;
	private EditText teainsertET3;
	private EditText teainsertET4;
	private EditText teainsertET5;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.insert_vis);//加载布局文件
		/*
		 * 初始化EditText
		 */
		teainsertET1 = (EditText) findViewById(R.id.teainsertET1);//初始化编辑文本框
		teainsertET2 = (EditText) findViewById(R.id.teainsertET2);
		teainsertET3 = (EditText) findViewById(R.id.teainsertET3);
		teainsertET4 = (EditText) findViewById(R.id.teainsertET4);
		teainsertET5 = (EditText) findViewById(R.id.teainsertET5);
	}

	/*
	 * 提交按钮监听
	 */
	public void visInsertLoad(View v) {
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = teainsertET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		String grade = teainsertET2.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		String phonenumber = teainsertET3.getText().toString().trim();
		String xueyuan = teainsertET4.getText().toString().trim();
		String people_number = teainsertET5.getText().toString().trim();
		Integer number = 0;
		if (!people_number.equals("")) {
			number = Integer.parseInt(people_number);//将字符型数据转换成整型给id
		}
		// 封装成老师对象
		Visitor vis = new Visitor(id, grade, phonenumber, xueyuan, number);

		// 调用TeacherDao插入方法进行插入
		VisitorDao dao = new VisitorDao(this);
		dao.insert(vis);

		/*
		 * 弹出对话框提示插入成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("注册成功");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}