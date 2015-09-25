package com.example.shixiuwen.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shixiuwen on 15-9-25.
 */
public class DatabaseHelper extends SQLiteOpenHelper{


    private static final String DB_NAME = "mydata.db";  //数据库名称
    private static final int version = 1;   //数据库版本

    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table nihao(username varchar(20) not null,password varchar(60) not null);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
