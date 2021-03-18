package com.example.studentselectcource;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.ssc.meet.Meet;
import com.example.ssc.meet.MeetDao;
import com.example.ssc.meet.MyMeetDao;

public class MeetDetailActivity extends Activity implements OnClickListener {
	private TextView title, course_detail;//定义文本视图
	private Button handleBtn;
	String from; //记录从哪个页面跳转过来
	Meet cource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);//重载父类
		setContentView(R.layout.meet_detail);//加载布局文件

		/*
		 * 标题显示
		 */

		/*获取Intent中的Bundle对象*/
		Bundle bundle = this.getIntent().getExtras();
		/*获取Bundle中的数据，注意类型和key*/
		String str_id = bundle.getString("m_id");
		Integer c_id = 0;
		if (!str_id.equals("")) {//判断是否为空
			c_id = Integer.parseInt(str_id);//将字符类型转换成int型
		}
		String c_name = bundle.getString("m_time");//获取Bundle中的数据
		from = bundle.getString("from");//获取Bundle中的数据

		System.out.println("哈哈哈"+from);

		title = (TextView) findViewById(R.id.title);//初始化文本视图
		course_detail = (TextView) findViewById(R.id.cource_detail);//初始化文本视图
		title.setText("讲解:"+c_name);

		handleBtn = (Button) findViewById(R.id.handle);//初始化按钮
		handleBtn.setOnClickListener(this);//监听器
		if (from.equals("我的讲解")) {//判断是否相同
			handleBtn.setText("删除");
		} else if (from.equals("选择讲解")) {//判断是否相同
			handleBtn.setText("选择");
		} else {
			handleBtn.setVisibility(View.GONE);//gone视图隐藏visble可见invisible不可见
		}

		// 调用CourceDao查询方法进行查询
		MeetDao dao = new MeetDao(this);
		cource = dao.select(c_id);

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
			course_detail.setText("参观ID：" + cource.getId() + "\n\n" + "参观时间："
					+ cource.getMeetTime() + "\n\n" + "参观学院："
					+ cource.getMeet_academy() + "\n\n" + "参观人数："
					+ cource.getMeet_people()  + "\n\n" + "参观班级："
					+ cource.getMeet_grade());
		}
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
			case R.id.handle:
				if (from.equals("我的讲解")) {
					// 调用MyCourceDao删除方法进行删除
					MyMeetDao dao = new MyMeetDao(this);
					dao.delete(cource.getId());
					/*
					 * 弹出对话框提示删除成功
					 */
					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setTitle("提示");
					builder.setMessage("成功取消ID号为：" + cource.getId() + "的选课信息！");
					builder.setPositiveButton("确定", null);
					builder.create();
					builder.show();
				} else if (from.equals("选择讲解")) {
					// 调用courceDao插入方法进行插入
					MyMeetDao dao = new MyMeetDao(this);
					// 封装成课程对象
					Integer id = cource.getId();
					String name = cource.getMeetTime();
					String lessonTime = cource.getMeet_academy();
					Integer lessonHour = cource.getMeet_people();
					String c_teacher = cource.getMeet_grade();
					Meet mycource = new Meet(id, name, lessonTime, lessonHour, c_teacher);
					dao.insert(mycource);
					/*
					 * 弹出对话框提示插入成功
					 */
					AlertDialog.Builder builder = new AlertDialog.Builder(this);
					builder.setTitle("提示");
					builder.setMessage("恭喜，选择成功！");
					builder.setPositiveButton("确定", null);
					builder.create();
					builder.show();
				} else {

				}
				break;

			default:
				break;
		}
	}
}
