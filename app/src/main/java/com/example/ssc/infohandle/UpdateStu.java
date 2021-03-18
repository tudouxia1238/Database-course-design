package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.student.Stu;
import com.example.ssc.student.StuDao;
import com.example.studentselectcource.R;

public class UpdateStu extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText stuupdateET1;//定义文本框
	private EditText stuupdateET2;
	private EditText stuupdateET3;
	private EditText stuupdateET4;
	private EditText stuupdateET5;
	private EditText stuupdateET6;
	private EditText stuupdateET7;
	private EditText stuupdateET8;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.update_stu);//加载布局文件
		/*
		 * 初始化EditText
		 */
		stuupdateET1 = (EditText) findViewById(R.id.stuupdateET1);//通过id查找编辑文本框，初始化编辑文本框
		stuupdateET2 = (EditText) findViewById(R.id.stuupdateET2);
		stuupdateET3 = (EditText) findViewById(R.id.stuupdateET3);
		stuupdateET4 = (EditText) findViewById(R.id.stuupdateET4);
		stuupdateET5 = (EditText) findViewById(R.id.stuupdateET5);
		stuupdateET6 = (EditText) findViewById(R.id.stuupdateET6);
		stuupdateET7 = (EditText) findViewById(R.id.stuupdateET7);
		stuupdateET8 = (EditText) findViewById(R.id.stuupdateET8);

	}

	/*
	 * 更新按钮监听
	 */
	public void stuUpdateLoad(View v) {
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = stuupdateET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {//判断输入的值是不是为空
			id = Integer.parseInt(str_id);//将字符串类型的str_id转换成int型
		}
		String name = stuupdateET2.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		String gender = stuupdateET3.getText().toString().trim();
		String telephone = stuupdateET4.getText().toString().trim();
		String password = stuupdateET5.getText().toString().trim();
		String academy = stuupdateET6.getText().toString().trim();
		String profession = stuupdateET7.getText().toString().trim();
		String str_grade = stuupdateET8.getText().toString().trim();
		Integer grade = 0;
		if (!str_grade.equals("")) {
			grade = Integer.parseInt(str_grade);
		}

		Stu stu = new Stu(id, name, gender, telephone, password, academy,
				profession, grade);// 封装成学生对象

		// 调用StuDao更新方法进行更新
		StuDao dao = new StuDao(this);
		dao.update(stu);

		/*
		 * 弹出对话框提示更新成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功更新学号为：" + id + "的讲解员信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}