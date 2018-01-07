package com.superclassroom;

/**
 * Created by Timber on 2017/11/3.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class ClassroomManager extends SQLiteOpenHelper {

    //定义一个创建表Book的SQLite语句
    private static final String CREATE_Classroom = "create table Classroom("
            + "id integer primary key autoincrement, "
            + "name text,"
            + "stime integer, "
            + "etime integer,"
            + "stage text,"
            + "username text)";
    private static final String insert1 = "insert into Classroom values(1,'301-301',null,null,'free','1')";
    private static final String insert2 = "insert into Classroom values(2,'301-302',null,null,'free','1')";
    private static final String insert3 = "insert into Classroom values(3,'301-303',null,null,'free','1')";
    private static final String insert4 = "insert into Classroom values(4,'302-301',null,null,'free','1')";
    private static final String insert5 = "insert into Classroom values(5,'302-302',null,null,'free','1')";
    private static final String insert6 = "insert into Classroom values(6,'302-303',null,null,'free','1')";
    private static final String insert7 = "insert into Classroom values(7,'303-301',null,null,'free','1')";
    private static final String insert8 = "insert into Classroom values(8,'303-302',null,null,'free','1')";
    private static final String insert9 = "insert into Classroom values(9,'303-303',null,null,'free','1')";
    private Context mContext;



    public ClassroomManager(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mContext = context;     //获取Context实例
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_Classroom);
        db.execSQL(insert1);db.execSQL(insert2);db.execSQL(insert3);db.execSQL(insert4);db.execSQL(insert5);db.execSQL(insert6);db.execSQL(insert7);db.execSQL(insert8);db.execSQL(insert9);

        Toast.makeText(mContext, "成功创建Database", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists Class");        //如果存在表Book，则删除该表
        onCreate(db);       //重新调用onCreate()，创建两张表
    }
}