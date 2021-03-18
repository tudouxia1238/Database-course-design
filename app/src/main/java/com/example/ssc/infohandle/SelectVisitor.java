package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ssc.visitor.Visitor;
import com.example.ssc.visitor.VisitorDao;
import com.example.studentselectcource.R;
public class SelectVisitor extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText teaselectET;
	/*
	 * 定义TextView
	 */
	private TextView teaselectTV;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.select_vis);//加载布局文件
		/*
		 * 初始化EditText
		 */
		teaselectET = (EditText) findViewById(R.id.teaselectET);
		// 初始化TextView
		teaselectTV = (TextView) findViewById(R.id.teaselectTV3);
	}

	/*
	 * 查询按钮监听
	 */
	public void teaSelectLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = teaselectET.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用teaDao查询方法进行查询
		VisitorDao dao = new VisitorDao(this);
		Visitor tea = dao.select(id);

		System.out.println(tea);//输出

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
			teaselectTV.setText("参观者ID：" + tea.getId() + "\n" + "参观班级："
					+ tea.getGrade() + "\n" + "参观者电话：" + tea.getTelephone() + "\n"
					+ "参观学院：" + tea.getXueyuan() + "\n" + "参观人数："
					+ tea.getNumber());//将查询到的内容输出到文本框中
		}
	}
}