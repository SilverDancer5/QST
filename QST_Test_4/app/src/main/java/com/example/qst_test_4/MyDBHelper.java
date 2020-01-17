package com.example.qst_test_4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDBHelper extends SQLiteOpenHelper {

    public MyDBHelper(Context context, String dbName, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbName, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table person(id integer primary key autoincrement, name text, sex text)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    //增
    public void add(ContentValues contentValues) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.insert("person", null, contentValues);
        sqLiteDatabase.close();
    }


    public List<Person> select() {
        List<Person> personList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        Cursor cursor = sqLiteDatabase.query("person", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Person person = new Person();
            person.setID(cursor.getInt(cursor.getColumnIndex("id")));
            person.setName(cursor.getString(cursor.getColumnIndex("name")));
            person.setSex(cursor.getString(cursor.getColumnIndex("sex")));
            personList.add(person);
        }
        sqLiteDatabase.close();
        return personList;
    }


    public void delete(int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.delete("person", "id = ?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }


    public void update(ContentValues contentValues, int id) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.update("person", contentValues, "id = ?", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

}