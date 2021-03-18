package com.example.studentselectcource;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.ssc.infohandle.DeleteMeet;
import com.example.ssc.infohandle.DeleteStu;
import com.example.ssc.infohandle.DeleteVisitor;
import com.example.ssc.infohandle.InsertMeet;
import com.example.ssc.infohandle.InsertStu;
import com.example.ssc.infohandle.InsertVisitor;
import com.example.ssc.infohandle.SelectMeet;
import com.example.ssc.infohandle.SelectStu;
import com.example.ssc.infohandle.SelectVisitor;
import com.example.ssc.infohandle.UpdateMeet;
import com.example.ssc.infohandle.UpdateStu;
import com.example.ssc.infohandle.UpdateVisitor;

public class InfoHandleActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.info_handle);
	}
	
	/*
	 * 插入学生按钮监听
	 */
	public void menuload1(View v) {
		Intent intent = new Intent();
		intent.setClass(this, InsertStu.class);
		startActivity(intent);
	}

	/*
	 * 删除学生按钮监听
	 */
	public void menuload2(View v) {
		Intent intent = new Intent();
		intent.setClass(this, DeleteStu.class);
		startActivity(intent);
	}

	/*
	 * 修改学生按钮监听
	 */
	public void menuload3(View v) {
		Intent intent = new Intent();
		intent.setClass(this, UpdateStu.class);
		startActivity(intent);
	}

	/*
	 * 查找学生按钮监听
	 */
	public void menuload4(View v) {
		Intent intent = new Intent();
		intent.setClass(this, SelectStu.class);
		startActivity(intent);
	}

	/*
	 * 插入课程按钮监听
	 */
	public void menuload5(View v) {
		Intent intent = new Intent();
		intent.setClass(this, InsertMeet.class);
		startActivity(intent);
	}

	/*
	 * 删除课程按钮监听
	 */
	public void menuload6(View v) {
		Intent intent = new Intent();
		intent.setClass(this, DeleteMeet.class);
		startActivity(intent);
	}

	/*
	 * 修改课程按钮监听
	 */
	public void menuload7(View v) {
		Intent intent = new Intent();
		intent.setClass(this, UpdateMeet.class);
		startActivity(intent);
	}

	/*
	 * 查找课程按钮监听
	 */
	public void menuload8(View v) {
		Intent intent = new Intent();
		intent.setClass(this, SelectMeet.class);
		startActivity(intent);
	}
	
	/*
	 * 插入老师按钮监听
	 */
	public void menuload9(View v) {
		Intent intent = new Intent();
		intent.setClass(this, InsertVisitor.class);
		startActivity(intent);
	}

	/*
	 * 删除老师按钮监听
	 */
	public void menuload10(View v) {
		Intent intent = new Intent();
		intent.setClass(this, DeleteVisitor.class);
		startActivity(intent);
	}

	/*
	 * 修改老师按钮监听
	 */
	public void menuload11(View v) {
		Intent intent = new Intent();
		intent.setClass(this, UpdateVisitor.class);
		startActivity(intent);
	}

	/*
	 * 查找老师按钮监听
	 */
	public void menuload12(View v) {
		Intent intent = new Intent();
		intent.setClass(this, SelectVisitor.class);
		startActivity(intent);
	}

	/**
	 * @help 返回上一个界面
	 */
	@Override
	public void onBackPressed() {
		finish();
	}
}
