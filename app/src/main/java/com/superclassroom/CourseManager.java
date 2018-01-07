package com.superclassroom;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Gif on 2018/1/2.
 */

public  class CourseManager extends SQLiteOpenHelper {

    private static final String CREATE_Course = "create table Course("
            + "id integer primary key autoincrement, "
            + "weektime text, "
            + "course1 text,"
            + "course2 text,"
            + "course3 text,"
            + "course4 text)";
    private Context mContext;
    public CourseManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;     //获取Context实例
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Course);
        Toast.makeText(mContext, "成功创建Database", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists Class");        //如果存在表Book，则删除该表
        onCreate(sqLiteDatabase);       //重新调用onCreate()，创建两张表
    }

}
