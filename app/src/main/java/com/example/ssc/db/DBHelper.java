package com.example.ssc.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {

	public DBHelper(Context context) {
		super(context, "studentCource.db", null, 1); //如果有该数据库，就打开，没有就创建一个
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		/*
		 * 创建tab_stu【学生表】
		 */
		String createTableStu = "create table tab_stu (stu_id int , stu_name varchar(10), "
				+ "stu_gender varchar(10), stu_telephone varchar(20),"
				+ " stu_password varchar(10), stu_academy varchar(20), "
				+ "stu_profession varchar(20), stu_grade int,primary key('stu_id')) ";

		db.execSQL(createTableStu);

		/*
		 * 创建tab_visitor【参观者表】
		 */
		String createTabVisitor = "create table tab_visitor (vis_id int, vis_grade varchar(10) ,"
				+ "people_number int , xueyuan varchar(25) ,"
				+ "phonenumber varchar(20) , primary key('vis_id') )";

		db.execSQL(createTabVisitor);
		/*
		 * 创建tab_work【讲解表】
		 */
		String createTabMeet = "create table tab_meet (meet_id int, meetTime varchar(25) ,"
				+ "meet_academy varchar(20),meet_people int ,"
				+ "meet_grade varchar(20), primary key('meet_id') )";

		db.execSQL(createTabMeet);

		/*
		 * 创建tab_mywork【我的讲解表】
		 */
		String createTabMyMeet = "create table tab_mymeet (meet_id int, meet_grade varchar(25) ,"
				+ "meetTime varchar(25) , meet_academy varchar(20) ,"
				+ "meet_people int , primary key('meet_id') )";

		db.execSQL(createTabMyMeet);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

	}

}