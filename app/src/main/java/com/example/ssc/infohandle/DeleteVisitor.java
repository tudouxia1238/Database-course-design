package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.ssc.visitor.VisitorDao;
import com.example.studentselectcource.R;

public class DeleteVisitor extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText teadeleteET;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.delete_vis);//加载布局文件delete_tea
		/*
		 * 初始化EditText
		 */
		teadeleteET = (EditText) findViewById(R.id.teadeleteET);

	}

	/*
	 * 删除按钮监听
	 */
	public void teaDeleteLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = teadeleteET.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {
			id = Integer.parseInt(str_id);
		}
		// 调用teaDao删除方法进行删除
		VisitorDao dao = new VisitorDao(this);
		dao.delete(id);

		/*
		 * 弹出对话框提示删除成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功删除ID号为：" + id + "的参观者信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}