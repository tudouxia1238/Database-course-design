package com.example.ssc.visitor;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssc.db.DBHelper;

public class VisitorDao {
	private DBHelper helper;
	public VisitorDao(Context context) {
		this.helper = new DBHelper(context);
	}

	public void insert(Visitor visitor) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("insert into tab_visitor values(?,?,?,?,?)", new Object[] {
				visitor.getId(), visitor.getGrade(), visitor.getTelephone(),
				visitor.getXueyuan(), visitor.getNumber() });
		db.close();
	}

	public void delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from tab_visitor where vis_id=?", new Object[] { id });
		db.close();
	}

	public void update(Visitor visitor) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL(
				"update tab_visitor set vis_grade=?,people_number=?,xueyuan=?, " +
						"phonenumber=? where vis_id=?",
				new Object[] { visitor.getGrade(),visitor.getNumber(),
						visitor.getXueyuan(), visitor.getNumber(),
						visitor.getId() });
		db.close();
	}

	public Visitor select(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from tab_visitor where vis_id=?",
				new String[] { id + "" });

		Visitor visitor = null;

		if (c.moveToNext()) {
			String grade = c.getString(c.getColumnIndex("vis_grade"));
			String phonenumber = c.getString(c.getColumnIndex("phonenumber"));
			String xueyuan = c.getString(c.getColumnIndex("xueyuan"));
			Integer number = c.getInt(c.getColumnIndex("people_number"));
			visitor = new Visitor(id, grade, phonenumber, xueyuan, number);
		}
		c.close();
		db.close();
		return visitor;
	}
	public ArrayList<HashMap<String, String>> getAllData() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query("tab_visitor", null, null,
				null, null, null, null);

		cursor.moveToFirst();
		// 生成动态数组，加入数据
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < cursor.getCount(); i++) {
			String t_id = Integer.toString(cursor.getInt(cursor.getColumnIndex("vis_id")));
			String name = cursor.getString(cursor.getColumnIndex("vis_grade"));
			String number = Integer.toString(cursor.getInt(cursor.getColumnIndex("people_number")));
			String xueyuan = cursor.getString(cursor.getColumnIndex("xueyuan"));
			String phonenumber = cursor.getString(cursor.getColumnIndex("phonenumber"));

			HashMap<String, String> map = new HashMap<String, String>();//第一个参数（此为String） 是对"键"的数据类型的限制第二个参数（此为Object ）是对"值"的数据类型的限制
			map.put("t_id", t_id);//插入值
			map.put("name", name);
			map.put("number", number);
			map.put("xueyuan", xueyuan);
			map.put("phonenumber", phonenumber);
			listItem.add(map);

			cursor.moveToNext();
		}
		return listItem;
	}
	
}
