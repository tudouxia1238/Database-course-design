package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.meet.Meet;
import com.example.ssc.meet.MeetDao;
import com.example.studentselectcource.R;
public class UpdateMeet extends Activity {
	private EditText courceupdateET1;
	private EditText courceupdateET2;
	private EditText courceupdateET3;
	private EditText courceupdateET4;
	private EditText courceupdateET5;
	private EditText courceupdateET6;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.update_meet);
		/*
		 * 初始化EditText
		 */
		courceupdateET1 = (EditText) findViewById(R.id.courceupdateET1);//初始化编辑文本框
		courceupdateET2 = (EditText) findViewById(R.id.courceupdateET2);
		courceupdateET3 = (EditText) findViewById(R.id.courceupdateET3);
		courceupdateET4 = (EditText) findViewById(R.id.courceupdateET4);
		courceupdateET5 = (EditText) findViewById(R.id.courceupdateET5);
	}

	/*
	 * 更新按钮监听
	 */
	public void courceUpdateLoad(View v) {//监听器
		/*
		 * 获取每个EditText中的值
		 */
		String str_id = courceupdateET1.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {//判断输入的文本是否为空
			id = Integer.parseInt(str_id);
		}
		String time = courceupdateET2.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		String academy = courceupdateET3.getText().toString().trim();
		Integer people = Integer.parseInt(courceupdateET4.getText().toString().trim());
		String grade = courceupdateET5.getText().toString().trim();
		// 封装成课程对象
		Meet cource = new Meet(id, time, academy, people, grade);

		// 调用CourceDao更新方法进行更新
		MeetDao dao = new MeetDao(this);
		dao.update(cource);

		/*
		 * 弹出对话框提示更新成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功更新ID号为：" + id + "的讲解信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}