package com.example.ssc.infohandle;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import com.example.studentselectcource.R;
import com.example.ssc.meet.MeetDao;


public class DeleteMeet extends Activity {
	/*
	 * 定义EditText
	 */
	private EditText courcedeleteET;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.delete_meet);//加载布局文件
		/*
		 * 初始化EditText
		 */
		courcedeleteET = (EditText) findViewById(R.id.courcedeleteET);

	}

	/*
	 * 删除按钮监听
	 */
	public void courceDeleteLoad(View v) {
		/*
		 * 获取EditText中的值
		 */
		String str_id = courcedeleteET.getText().toString().trim();//获取编辑文本框中的内容 .String（）转换成字符转.trim（） 去掉输入中的空格
		Integer id = 0;
		if (!str_id.equals("")) {//判断输入内容是否为空
			id = Integer.parseInt(str_id);
		}
		// 调用courceDao删除方法进行删除
		MeetDao dao = new MeetDao(this);
		dao.delete(id);

		/*
		 * 弹出对话框提示删除成功
		 */
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("提示");
		builder.setMessage("成功删除ID号为：" + id + "的讲解信息！");
		builder.setPositiveButton("确定", null);
		builder.create();
		builder.show();
	}
}