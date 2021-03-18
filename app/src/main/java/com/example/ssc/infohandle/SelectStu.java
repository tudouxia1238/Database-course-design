 package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ssc.student.Stu;
import com.example.ssc.student.StuDao;
import com.example.studentselectcource.R;

public class SelectStu extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText stuselectET;
	/*
	 * 定义TextView
	 */
	private TextView stuselectTV; //定义文本框

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.select_stu);//加载布局文件select_stu
		/*
		 * 初始化EditText
		 */
		stuselectET = (EditText) findViewById(R.id.stuselectET);
		// 初始化TextView
		stuselectTV = (TextView) findViewById(R.id.stuselectTV3);
	}

	/*
	 * 查询按钮监听
	 */
	public void stuSelectLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = stuselectET.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);//将字符型数据转换成整型给id
		}
		// 调用StuDao查询方法进行查询
		StuDao dao = new StuDao(this);//调用StuDao中的select（）方法进行查询
		Stu stu = dao.select(id);

		if (stu == null) {
			/*
			 * 弹出对话框提示查询失败
			 */
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示");
			builder.setMessage("您查询的讲解员信息不存在！");
			builder.setPositiveButton("确定", null);
			builder.create();
			builder.show();
		} else {
			// 显示出查询结果
			stuselectTV.setText("讲解员学号：" + stu.getId() + "\n" + "姓   名："
					+ stu.getName() + "\n" + "性   别：" + stu.getGender() +"\n"+ "密  码：" + stu.getPassword() + "\n"
					+ "电  话：" + stu.getTelephone() + "\n" + "学  院：" + stu.getAcademy()
					+ "\n" + "专  业：" + stu.getProfession() + "\n" + "年  级："
					+ stu.getGrade());//将查询到的信息输出到文本框中
		}
	}
}