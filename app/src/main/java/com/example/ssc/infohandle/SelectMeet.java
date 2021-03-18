package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ssc.meet.Meet;
import com.example.ssc.meet.MeetDao;
import com.example.studentselectcource.R;

public class SelectMeet extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText courceselectET;
	/*
	 * 定义TextView
	 */
	private TextView courceselectTV;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.select_meet_two);
		/*
		 * 初始化EditText
		 */
		courceselectET = (EditText) findViewById(R.id.courceselectET);
		// 初始化TextView
		courceselectTV = (TextView) findViewById(R.id.courceselectTV3);
	}

	/*
	 * 查询按钮监听
	 */
	public void courceSelectLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = courceselectET.getText().toString().trim();
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用CourceDao查询方法进行查询
		MeetDao dao = new MeetDao(this);
		Meet cource = dao.select(id);
		System.out.println(cource);

		if (cource == null) {
			/*
			 * 弹出对话框提示查询失败
			 */
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示");
			builder.setMessage("您查询的讲解信息不存在！");
			builder.setPositiveButton("确定", null);
			builder.create();
			builder.show();
		} else {
			// 显示出查询结果
			courceselectTV.setText("讲解ID：" + cource.getId() + "\n" + "参观时间："
					+ cource.getMeetTime() + "\n" + "参观学院：" + cource.getMeet_academy() + "\n"
					+ "参观人数：" + cource.getMeet_people() + "\n" + "参观班级："
					+ cource.getMeet_grade() );
		}
	}
}