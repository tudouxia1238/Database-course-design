package com.example.ssc.meet;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssc.db.DBHelper;

public class MyMeetDao {
	private DBHelper helper;

	public MyMeetDao(Context context){ this.helper = new DBHelper(context);}

	public void insert(Meet meet){
		SQLiteDatabase db = helper.getWritableDatabase();//打开SQLite数据库
		db.execSQL("insert into tab_mymeet values(?,?,?,?,?)", new Object[] {
				meet.getId(), meet.getMeetTime(), meet.getMeet_academy(),
				meet.getMeet_people(),meet.getMeet_grade()});
		db.close();
	}

	public void delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();
		db.execSQL("delete from tab_mymeet where meet_id=?", new Object[] { id });
		db.close();
	}

	public Meet select(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor c = db.rawQuery("select * from tab_mymeet where meet_id=?",
				new String[] { id + "" });

		Meet meet = null;

		if (c.moveToNext()) {//逐条读取数据
			String time = c.getString(c.getColumnIndex("meet_time"));
			String academy = c.getString(c.getColumnIndex("meet_academy"));
			Integer people = c.getInt(c.getColumnIndex("meet_people"));
			String grade = c.getString(c.getColumnIndex("meet_grade"));
			meet = new Meet(id, time, academy, people, grade);
		}
		c.close();
		db.close();
		return meet;
	}

	public ArrayList<HashMap<String, String>> getAllData() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query("tab_mymeet", null, null, null, null, null, null);

		cursor.moveToFirst();
		// 生成动态数组，加入数据
		ArrayList<HashMap<String, String>> listItem = new ArrayList<HashMap<String, String>>();
		for (int i = 0; i < cursor.getCount(); i++) {
			String m_id = Integer.toString(cursor.getInt(cursor.getColumnIndex("meet_id")));
			String m_time = cursor.getString(cursor.getColumnIndex("meetTime"));
			String m_academy = cursor.getString(cursor.getColumnIndex("meet_academy"));
			String m_people = Integer.toString(cursor.getInt(cursor.getColumnIndex("meet_people")));
			String m_grade = cursor.getString(cursor.getColumnIndex("meet_grade"));

			HashMap<String, String> map = new HashMap<String, String>();
			map.put("m_id", m_id);
			map.put("m_time", m_time);
			map.put("m_academy", m_academy);
			map.put("m_people", m_people);
			map.put("m_grade", m_grade);
			listItem.add(map);

			cursor.moveToNext();
		}

		return listItem;
	}
	
}