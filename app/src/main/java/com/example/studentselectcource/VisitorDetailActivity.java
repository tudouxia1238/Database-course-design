package com.example.studentselectcource;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.TextView;

import com.example.ssc.visitor.Visitor;
import com.example.ssc.visitor.VisitorDao;

public class VisitorDetailActivity extends Activity {
	private TextView title, teacher_detail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.visitor_detail);

		/* 获取Intent中的Bundle对象 */
		Bundle bundle = this.getIntent().getExtras();
		/* 获取Bundle中的数据，注意类型和key */
		String str_id = bundle.getString("t_id");
		Integer t_id = 0;
		if (!str_id.equals("")) {//判断是否为空
			t_id = Integer.parseInt(str_id);
		}
		String t_name = bundle.getString("name");

		title = (TextView) findViewById(R.id.title);
		teacher_detail = (TextView) findViewById(R.id.teacher_detail);
		title.setText("参观者:" + t_name);

		// 调用teaDao查询方法进行查询
		VisitorDao dao = new VisitorDao(this);
		Visitor tea = dao.select(t_id);

		if (tea == null) {
			/*
			 * 弹出对话框提示查询失败
			 */
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("提示");
			builder.setMessage("您查询的参观者信息不存在！");
			builder.setPositiveButton("确定", null);
			builder.create();
			builder.show();
		} else {
			// 显示出查询结果
			teacher_detail.setText("参观者ID：" + tea.getId() + "\n\n" + "参观班级："
					+ tea.getGrade() + "\n\n" + "电话：" + tea.getTelephone() + "\n\n"
					+ "参观学院：" + tea.getXueyuan() + "\n\n" + "参观班级："
					+ tea.getNumber());
		}
	}

}
