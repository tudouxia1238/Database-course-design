package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.visitor.Visitor;
import com.example.ssc.visitor.VisitorDao;
import com.example.studentselectcource.R;

public class UpdateVisitor extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText teaupdateET1;//定义编辑文本框
	private EditText teaupdateET2;
	private EditText teaupdateET3;
	private EditText teaupdateET4;
	private EditText teaupdateET5;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.update_vis);//加载布局文件
		/*
		 * 初始化EditText
		 */
		teaupdateET1 = (EditText) findViewById(R.id.teaupdateET1);//通过id查找编辑文本框，初始化编辑文本框
		teaupdateET2 = (EditText) findViewById(R.id.teaupdateET2);
		teaupdateET3 = (EditText) findViewById(R.id.teaupdateET3);
		teaupdateET4 = (EditText) findViewById(R.id.teaupdateET4);
		teaupdateET5 = (EditText) findViewById(R.id.teaupdateET5);
	}

	/*
	 * 更新按钮监听
	 */
	public void teaUpdateLoad(View v) {
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = teaupdateET1.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {//判断输入是否为空
			id = Integer.parseInt(str_id);
		}
		String grade = teaupdateET2.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		String phonenumber = teaupdateET3.getText().toString().trim();
		String xueyuan = teaupdateET4.getText().toString().trim();
		String people_number = teaupdateET5.getText().toString().trim();
		Integer number=0;
		if(!people_number.equals("")){
			number = Integer.parseInt(people_number);
		}
		// 封装成老师对象
		Visitor tea = new Visitor(id, grade, phonenumber, xueyuan, number);

		// 调用TeacherDao更新方法进行更新
		VisitorDao dao = new VisitorDao(this);
		dao.update(tea);

		/*
		 * 弹出对话框提示更新成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功更新ID号为：" + id + "的参观者信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}