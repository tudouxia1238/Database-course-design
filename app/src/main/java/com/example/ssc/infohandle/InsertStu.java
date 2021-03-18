package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.student.Stu;
import com.example.ssc.student.StuDao;
import com.example.studentselectcource.R;

public class InsertStu extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText stuinsertET1;//定义EditText 编辑文本框
	private EditText stuinsertET2;
	private EditText stuinsertET3;
	private EditText stuinsertET4;
	private EditText stuinsertET5;
	private EditText stuinsertET6;
	private EditText stuinsertET7;
	private EditText stuinsertET8;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.insert_stu);//加载布局文件
		/*
		 * 初始化EditText
		 */
		stuinsertET1 = (EditText) findViewById(R.id.stuinsertET1);//强制类型转换  找到布局文件中的EditText，初始化EditText
		stuinsertET2 = (EditText) findViewById(R.id.stuinsertET2);
		stuinsertET3 = (EditText) findViewById(R.id.stuinsertET3);
		stuinsertET4 = (EditText) findViewById(R.id.stuinsertET4);
		stuinsertET5 = (EditText) findViewById(R.id.stuinsertET5);
		stuinsertET6 = (EditText) findViewById(R.id.stuinsertET6);
		stuinsertET7 = (EditText) findViewById(R.id.stuinsertET7);
		stuinsertET8 = (EditText) findViewById(R.id.stuinsertET8);

	}

	/*
	 * 提交按钮监听
	 */
	public void stuInsertLoad(View v) {  //监听器
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = stuinsertET1.getText().toString().trim();//获取编辑文本框中的内容 .String转换成字符转.trim 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {  //假如输入的不为空
			id = Integer.parseInt(str_id);//将字符型数据转换成整型给id
		}
		String name = stuinsertET2.getText().toString().trim();//获取编辑文本框中的内容 .String转换成字符转.trim 去掉输入中的空格
		String gender = stuinsertET3.getText().toString().trim();
		String telephone = stuinsertET4.getText().toString().trim();
		String password= stuinsertET5.getText().toString().trim();
		String academy = stuinsertET6.getText().toString().trim();
		String profession = stuinsertET7.getText().toString().trim();
		String str_grade = stuinsertET8.getText().toString().trim();
		Integer grade = 0;
		if (!str_grade.equals("")) {
			grade = Integer.parseInt(str_grade);//将字符型数据转换成整型给id
		}
		//
		Stu stu = new Stu(id,  name, gender, telephone, password,  academy, profession, grade);// 封装成学生对象

		// 调用StuDao插入方法进行插入
		StuDao dao = new StuDao(this);//调用StuDao中的处理方法
		dao.insert(stu);//调用insert（）方法

		/*
		 * 弹出对话框提示插入成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功插入讲解员信息！");
		builder.setPositiveButton("确定", null);//输出提示框点击确定结束
		builder.create();
		builder.show();
	}

}