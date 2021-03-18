package com.example.ssc.meet;

import java.util.ArrayList;
import java.util.HashMap;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.ssc.db.DBHelper;

public class MeetDao {
	private DBHelper helper;

	public MeetDao(Context context) {this.helper = new DBHelper(context);}

	public void insert(Meet meet){
		SQLiteDatabase db= helper.getWritableDatabase();
		db.execSQL("insert into tab_meet values(?,?,?,?,?)",new Object[] {
				meet.getId(), meet.getMeetTime(), meet.getMeet_academy(),
				meet.getMeet_people(), meet.getMeet_grade() });
		db.close();
	}

	public void delete(int id) {
		SQLiteDatabase db = helper.getWritableDatabase();//打开SQLite数据库
		db.execSQL("delete from tab_meet where meet_id=?", new Object[] { id });//执行SQL语句
		db.close();//关闭数据库
	}

	public void update(Meet meet) {
		SQLiteDatabase db = helper.getWritableDatabase();//打开SQLite数据库
		db.execSQL(
				"update tab_meet set meetTime=?,meet_academy=?,meet_people=?, meet_grade=? where meet_id=?",
				new Object[] { meet.getMeetTime(), meet.getMeet_academy(),
						meet.getMeet_people(), meet.getMeet_grade(), meet.getId() });//执行SQL语句
		db.close();//关闭数据库
	}

	public Meet select(int id) {
		SQLiteDatabase db = helper.getReadableDatabase();//打开SQLite数据库
		Cursor c = db.rawQuery("select * from tab_meet where meet_id=?",
				new String[] { id + "" });//执行SQL语句

		Meet meet = null;

		if (c.moveToNext()) {
			String meetTime = c.getString(c.getColumnIndex("meetTime"));
			String meet_academy = c.getString(c.getColumnIndex("meet_academy"));
			Integer meet_people = c.getInt(c.getColumnIndex("meet_people"));
			String meet_grade = c.getString(c.getColumnIndex("meet_grade"));
			meet = new Meet(id, meetTime, meet_academy, meet_people, meet_grade);
		}
		c.close();
		db.close();
		return meet;
	}

	public ArrayList<HashMap<String, String>> getAllData() {
		SQLiteDatabase db = helper.getReadableDatabase();
		Cursor cursor = db.query("tab_meet", null, null, null,
				null, null, null);

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
