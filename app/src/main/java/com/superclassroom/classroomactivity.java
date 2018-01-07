package com.superclassroom;

/**
 * Created by Timber on 2017/11/3.
 */

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class classroomactivity extends Activity {
    private MyDBHelper moh;
    private SQLiteDatabase sd;
    private ArrayList<classroom> roomlist;
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_open_helper);
        //创建或打开数据库
        moh=new MyDBHelper(this,"Classroom.db",null,5);
        sd= moh.getReadableDatabase();
        roomlist = new ArrayList<>();
        //扫描数据库,将数据库信息放入studentlist
        Cursor cursor = sd.rawQuery("select * from Classroom",null);
        while (cursor.moveToNext()){
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String time = cursor.getString(cursor.getColumnIndex("time"));
            String stage = cursor.getString(cursor.getColumnIndex("stage"));
            classroom st = new classroom(name,time,stage);    //student_info存一个条目的数据
            roomlist.add(st);//把数据库的每一行加入数组中
        }
        //获取ListView,并通过Adapter把studentlist的信息显示到ListView
        //为ListView设置一个适配器,getCount()返回数据个数;getView()为每一行设置一个条目
        lv=(ListView)findViewById(R.id.room_lv);
        lv.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return roomlist.size();
            }

            //ListView的每一个条目都是一个view对象
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;
                //对ListView的优化，convertView为空时，创建一个新视图；convertView不为空时，代表它是滚出
                //屏幕，放入Recycler中的视图,若需要用到其他layout，则用inflate(),同一视图，用fiindViewBy()
                if(convertView==null){
                    view = View.inflate(getBaseContext(),R.layout.roomlayout,null);
                }
                else{
                    view = convertView;
                }

                //从studentlist中取出一行数据，position相当于数组下标,可以实现逐行取数据
                classroom st = roomlist.get(position);
                TextView name = (TextView)view.findViewById(R.id.room_name);
                TextView time = (TextView)view.findViewById(R.id.room_time);
                TextView stage = (TextView)view.findViewById(R.id.room_stage);
                name.setText(st.getName());
                time.setText(st.getTime());
                stage.setText(st.getStage());

                return view;
            }

            @Override
            public Object getItem(int position) {
                return null;
            }

            @Override
            public long getItemId(int position) {
                return 0;
            }
        });
    }
}