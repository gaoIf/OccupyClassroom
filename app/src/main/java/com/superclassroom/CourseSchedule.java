package com.superclassroom;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Gif on 2018/1/2.
 */

public class CourseSchedule extends Activity {
    private CourseManager mo;
    private SQLiteDatabase s;
    private ArrayList<CourseData> courselist;
    private ListView l1;
    private Button BackButton1;                      //返回按钮
    private String tmpname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule);
        Intent i = getIntent();
        tmpname = i.getStringExtra("user_name1");
        //创建数据库
        mo = new CourseManager(this, "Course1.db", null, 1);
        s = mo.getReadableDatabase();
        courselist = new ArrayList<>();
        //扫描数据库,将数据库信息放入roomlist
        Cursor cursor = s.rawQuery("select * from Course", null);
        while (cursor.moveToNext()) {
            String weektime = cursor.getString(cursor.getColumnIndex("weektime"));
            String course1 = cursor.getString(cursor.getColumnIndex("course1"));
            String course2 = cursor.getString(cursor.getColumnIndex("course2"));
            String course3 = cursor.getString(cursor.getColumnIndex("course3"));
            String course4 = cursor.getString(cursor.getColumnIndex("course4"));
            CourseData st = new CourseData(weektime, course1, course2, course3, course4);    //student_info存一个条目的数据
            courselist.add(st);//把数据库的每一行加入数组中
        }
        //获取ListView,并通过Adapter把courselist的信息显示到ListView
        //为ListView设置一个适配器,getCount()返回数据个数;getView()为每一行设置一个条目
        l1 = (ListView) findViewById(R.id.course);
        l1.setAdapter(new BaseAdapter() {
            @Override
            public int getCount() {
                return courselist.size();
            }

            //ListView的每一个条目都是一个view对象
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view;
                //对ListView的优化，convertView为空时，创建一个新视图；convertView不为空时，代表它是滚出
                //屏幕，放入Recycler中的视图,若需要用到其他layout，则用inflate(),同一视图，用fiindViewBy()
                if (convertView == null) {
                    view = View.inflate(getBaseContext(), R.layout.schedulelayout, null);
                } else {
                    view = convertView;
                }

                //从roomlist中取出一行数据，position相当于数组下标,可以实现逐行取数据
                CourseData st = courselist.get(position);
                TextView weektime = (TextView) view.findViewById(R.id.weektime);
                TextView course1 = (TextView) view.findViewById(R.id.coursetime1);
                TextView course2 = (TextView) view.findViewById(R.id.coursetime2);
                TextView course3 = (TextView) view.findViewById(R.id.coursetime3);
                TextView course4 = (TextView) view.findViewById(R.id.coursetime4);
                weektime.setText(st.getWeektime());
                course1.setText(st.getCourse1());
                course2.setText(st.getCourse2());
                course3.setText(st.getCourse3());
                course4.setText(st.getCourse4());

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
        BackButton1 = (Button) findViewById(R.id.courseback);
        BackButton1.setOnClickListener(mListener);
    }
        View.OnClickListener mListener = new View.OnClickListener() {                  //不同按钮按下的监听事件选择
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.courseback:                            //教室界面的返回按钮
                        Intent intent_course_to_usercerter = new Intent(CourseSchedule.this, UserCerter.class);    //切换Login Activity至User Activity
                        intent_course_to_usercerter.putExtra("user_name0", tmpname);
                        startActivity(intent_course_to_usercerter);
                        finish();
                        break;
                }
            }
        };
    }
