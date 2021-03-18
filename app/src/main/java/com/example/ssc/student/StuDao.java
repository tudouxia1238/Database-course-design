package com.example.ssc.student;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssc.db.DBHelper;

public class StuDao {
	private DBHelper helper;

	public StuDao(Context context) {
		this.helper = new DBHelper(context);
	}

	public void insert(Stu stu) {//插入讲解员方法
		SQLiteDatabase db = helper.getWritableDatabase();//打开数据库Sqlite
		db.execSQL(
				"insert into tab_stu values(?,?,?,?,?,?,?,?)",//执行sql语句
				new Object[] { stu.getId(), stu.getName(), stu.getGender(),
						stu.getTelephone(), stu.getPassword(), stu.getAcademy(),
						stu.getProfession(), stu.getGrade() });//获取数据
		db.close();//关闭数据库
	}

	public void delete(int id) {//删除讲解员方法
		SQLiteDatabase db = helper.getWritableDatabase();//打开数据库Sqlite
		db.execSQL("delete from tab_stu where stu_id = ?", new Object[] { id });//将数据保存
		db.close();//关闭数据库
	}

	public void update(Stu stu) {//更新讲解员信息方法
		SQLiteDatabase db = helper.getWritableDatabase();//打开数据库Sqlite
		db.execSQL(
				"update tab_stu set stu_name=?,stu_gender=?,stu_telephone=?,stu_password=?," +
						"stu_academy=?,stu_profession=?,stu_grade=? where stu_id=?",
				new Object[] { stu.getName(), stu.getGender(), stu.getTelephone(),
						stu.getPassword(), stu.getAcademy(),
						stu.getProfession(), stu.getGrade(), stu.getId() });//获取数据
		db.close();
	}

	public Stu select(int id) {//查找讲解员信息方法
		SQLiteDatabase db = helper.getReadableDatabase();//打开数据库
		Cursor c = db.rawQuery("select * from tab_stu where stu_id=?",
				new String[] { id + "" });//执行sql语句

		Stu stu = null;
		if (c.moveToNext()) {//逐条查询
			String name = c.getString(c.getColumnIndex("stu_name"));//转换成字符串类型给name
			String password = c.getString(c.getColumnIndex("stu_password"));
			String telephone = c.getString(c.getColumnIndex("stu_telephone"));
			String gender = c.getString(c.getColumnIndex("stu_gender"));
			String academy = c.getString(c.getColumnIndex("stu_academy"));
			String profession = c.getString(c.getColumnIndex("stu_profession"));
			Integer grade = c.getInt(c.getColumnIndex("stu_grade"));

			stu = new Stu(id, name, password, telephone , gender, academy,
					profession, grade);
		}
		c.close();
		db.close();
		return stu;
	}

	public Stu selectname(String name) {
		SQLiteDatabase db = helper.getReadableDatabase();//打开数据库
		Cursor c = db.rawQuery("select * from tab_stu where stu_name=?",
				new String[] { name + "" });

		Stu stu = null;
		if (c.moveToNext()) {
			Integer id = c.getInt(c.getColumnIndex("stu_id"));
			String password = c.getString(c.getColumnIndex("stu_password"));
			String telephone = c.getString(c.getColumnIndex("stu_telephone"));
			String gender = c.getString(c.getColumnIndex("stu_gender"));
			String academy = c.getString(c.getColumnIndex("stu_academy"));
			String profession = c.getString(c.getColumnIndex("stu_profession"));
			Integer grade = c.getInt(c.getColumnIndex("stu_grade"));

			stu = new Stu(id, name, password, telephone, gender, academy,
					profession, grade);
		}
		c.close();
		db.close();//关闭数据库
		return stu;
	}
}
