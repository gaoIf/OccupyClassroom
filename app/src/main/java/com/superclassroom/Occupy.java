package com.superclassroom;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListPopupWindow;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Map;

import mima.OTPVerify;

/**
 * Created by Timber on 2017/11/4.
 */

public class Occupy extends AppCompatActivity {
    private EditText mOccupyClass;
    private Button mSureOccupy;
    private Button mOccupyBack;
    private MyDBHelper dbHelper;
    private SQLiteDatabase db1;
    private String tmpname;
    private Spinner mStarttime;
    private Spinner mEndtime;
    private List<Integer> list1;
    private List<Integer> list2;
    private ArrayAdapter<Integer> arr1;
    private ArrayAdapter<Integer> arr2;
    private int list1sel;
    private int list2sel;
    private EditText mSecurity;
    private ListPopupWindow listPopupWindow1 = null;
    private ListPopupWindow listPopupWindow2 = null;
    private ImageView arrowImageView1;
    private ImageView arrowImageView2;
    private TextView chooseText1;
    private TextView chooseText2;
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private SortAadapter adapter1 = null;
    private SortAadapter adapter2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.occupy);

        Intent i = getIntent();
        tmpname = i.getStringExtra("user_name2");


        mOccupyClass = (EditText) findViewById(R.id.occupyclass);
        mOccupyBack = (Button) findViewById(R.id.occupyback);
        mSureOccupy = (Button) findViewById(R.id.sureoccupy);


        mSecurity = (EditText) findViewById(R.id.security);
        mOccupyBack.setOnClickListener(m_register_Listener);
        mSureOccupy.setOnClickListener(m_register_Listener);
        dbHelper = new MyDBHelper(this, "Classroom.db", null, 5);
        db1 = dbHelper.getWritableDatabase();


        linearLayout1 = (LinearLayout) findViewById(R.id.linearLayout1);
        linearLayout2 = (LinearLayout) findViewById(R.id.linearLayout2);
        arrowImageView1 = (ImageView) findViewById(R.id.arrow1);
        arrowImageView2 = (ImageView) findViewById(R.id.arrow2);
        chooseText1 = (TextView) findViewById(R.id.chooseText1);
        chooseText2 = (TextView) findViewById(R.id.chooseText2);


        linearLayout1.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showListPopupWindow1(linearLayout1);
            }
        });
        linearLayout2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                showListPopupWindow2(linearLayout2);
            }
        });
        /*        原生Spanner
        list1 = new ArrayList<Integer>();
        list1.add(0);
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(6);
        list1.add(7);
        list1.add(8);
        list1.add(9);
        list1.add(10);
        list1.add(11);
        list1.add(12);
        list1.add(13);
        list1.add(14);
        list1.add(15);
        list1.add(16);
        list1.add(17);
        list1.add(18);
        list1.add(19);
        list1.add(20);
        list1.add(21);
        list1.add(22);
        list1.add(23);
        list1.add(24);


        list2 = new ArrayList<Integer>();
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(6);
        list2.add(7);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        list2.add(11);
        list2.add(12);
        list2.add(13);
        list2.add(14);
        list2.add(15);
        list2.add(16);
        list2.add(17);
        list2.add(18);
        list2.add(19);
        list2.add(20);
        list2.add(21);
        list2.add(22);
        list2.add(23);
        list2.add(24);

        arr1 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, list1);
        arr1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mStarttime.setAdapter(arr1);

        arr2 = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, list2);
        arr2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mEndtime.setAdapter(arr2);

        mStarttime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                list1sel = (int) mStarttime.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mEndtime.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                list2sel = (int) mEndtime.getSelectedItem();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }

    /******************************************************************************下拉选项框模块*************************************************************************************************/

    private class SortAadapter extends ArrayAdapter {
        private String[] strs = {"0", "1", "2", "3", "4", "5", "6"};
        private LayoutInflater inflater;
        private int res;

        public SortAadapter(Context context, int resource) {
            super(context, resource);
            inflater = LayoutInflater.from(context);
            res = resource;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null)
                convertView = inflater.inflate(res, null);

            TextView text = (TextView) convertView.findViewById(android.R.id.text1);
            text.setText(getItem(position));
            text.setTextColor(Color.WHITE);
            text.setTextSize(10);
            convertView.setBackgroundColor(Color.RED);
            return convertView;
        }

        @Override
        public String getItem(int position) {
            return strs[position];
        }

        @Override
        public int getCount() {
            return strs.length;
        }
    }

    public void showListPopupWindow1(View view) {
        if (listPopupWindow1 == null)
            listPopupWindow1 = new ListPopupWindow(this);
        if (adapter1 == null) {
            adapter1 = new SortAadapter(this, android.R.layout.simple_list_item_1);
            // ListView适配器
            listPopupWindow1.setAdapter(adapter1);
            // 选择item的监听事件
            listPopupWindow1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                    Toast.makeText(getApplicationContext(), adapter1.getItem(pos), Toast.LENGTH_SHORT).show();
                    chooseText1.setText(adapter1.getItem(pos));
                    listPopupWindow1.dismiss();
                }
            });
            listPopupWindow1.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    //旋转0度是复位ImageView
                    arrowImageView1.animate().setDuration(500).rotation(0).start();
                }
            });
        }
        // ListPopupWindow的锚,弹出框的位置是相对当前View的位置
        listPopupWindow1.setAnchorView(view);
        listPopupWindow1.setVerticalOffset(dip2px(this, 5));
        // 对话框的宽高
        listPopupWindow1.setWidth(view.getWidth());
        listPopupWindow1.setModal(true);
        listPopupWindow1.show();
        arrowImageView1.animate().setDuration(500).rotation(180).start();
    }

    public void showListPopupWindow2(View view) {
        if (listPopupWindow2 == null)
            listPopupWindow2 = new ListPopupWindow(this);
        if (adapter2 == null) {
            adapter2 = new SortAadapter(this, android.R.layout.simple_list_item_2);
            // ListView适配器
            listPopupWindow2.setAdapter(adapter2);
            // 选择item的监听事件
            listPopupWindow2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                    Toast.makeText(getApplicationContext(), adapter1.getItem(pos), Toast.LENGTH_SHORT).show();
                    chooseText2.setText(adapter2.getItem(pos));
                    listPopupWindow2.dismiss();
                }
            });
            listPopupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
                    //旋转0度是复位ImageView
                    arrowImageView2.animate().setDuration(500).rotation(0).start();
                }
            });
        }
        // ListPopupWindow的锚,弹出框的位置是相对当前View的位置
        listPopupWindow2.setAnchorView(view);
        listPopupWindow2.setVerticalOffset(dip2px(this, 5));
        // 对话框的宽高
        listPopupWindow2.setWidth(view.getWidth());
        listPopupWindow2.setModal(true);
        listPopupWindow2.show();
        arrowImageView2.animate().setDuration(500).rotation(180).start();
    }

    public static int dip2px(Context context, float dipValue) {
        float sDensity = context.getResources().getDisplayMetrics().density;
        final float scale = sDensity;
        return (int) (dipValue * scale + 0.5f);
    }


    /**********************************************************************************动态密码验证模块*****************************************************************************************************/


    private int testCheckPwdz201() {
        String seed = "llF9457D58DAD9A6CD9C646A58C229E5BACC62C5AFFAF56421";
        String sOTP = mSecurity.getText().toString().trim();
        Map hashMap;
        // Scanner sc = new Scanner(System.in);
        int iDrift = 0;
        long lSucc = 0;
        long nReturn;
        int p = 0;

        System.out.print("请输入教室密钥:");
        if (!(sOTP.equals("quit"))) {

            hashMap = OTPVerify.ET_CheckPwdz201(
                    seed,                                    //令牌密钥
                    System.currentTimeMillis() / 1000,        //调用本接口计算机的当前时间
                    0,                                        //给0
                    60,                                        //给60，因为每60秒变更新的动态口令
                    iDrift,                                //漂移值，用于调整硬件与服务器的时间偏差，见手册说明
                    20,                                        //认证窗口，见手册说明
                    lSucc,                                    //成功值，用于调整硬件与服务器的时间偏差，见手册说明
                    sOTP);                                    //要认证的动态口令OTP

            nReturn = (long) hashMap.get("returnCode");
            p = Integer.parseInt(String.valueOf(nReturn));
        }

        return p;
    }


    /***************************************************************************************************************************************************************************************/

    OnClickListener m_register_Listener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.occupyback:
                    Intent intent_Occupy_to_roomactivity = new Intent(Occupy.this, classroomactivity.class);
                    //Bundle bundle1 = new Bundle();
                    //bundle1.putString("name",tmpname);
                    //intent_Occupy_to_roomactivity.putExtras(bundle1);
                    intent_Occupy_to_roomactivity.putExtra("user_name1", tmpname);
                    startActivity(intent_Occupy_to_roomactivity);
                    finish();
                    break;
                case R.id.sureoccupy:
                    Cursor cursor = db1.rawQuery("select * from Classroom", null);
                    String ClassName = mOccupyClass.getText().toString().trim();
                    while (cursor.moveToNext()) {
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String stage = cursor.getString(cursor.getColumnIndex("stage"));
                        String stime = cursor.getString(cursor.getColumnIndex("stime"));
                        String etime = cursor.getString(cursor.getColumnIndex("etime"));
                        if ((name.equals(ClassName)) && (stage.equals("free")) && (chooseText1.getText().toString().trim().compareTo(chooseText2.getText().toString().trim()) < 0)) {
                            int k = testCheckPwdz201();
                            // Toast.makeText(getApplicationContext(), k, Toast.LENGTH_SHORT).show()
                            if (k == 0) {
                                ContentValues contentValues1 = new ContentValues();
                                ContentValues contentValues2 = new ContentValues();
                                ContentValues contentValues3 = new ContentValues();
                                ContentValues contentValues4 = new ContentValues();
                                contentValues1.put("stage", "busy");
                                contentValues2.put("stime", chooseText1.getText().toString().trim());
                                contentValues3.put("etime", chooseText2.getText().toString().trim());
                                contentValues4.put("username", tmpname);
                                String[] classname = {ClassName};
                                db1.update("Classroom", contentValues1, "name = ?", classname);
                                db1.update("Classroom", contentValues2, "name = ?", classname);
                                db1.update("Classroom", contentValues3, "name = ?", classname);
                                db1.update("Classroom", contentValues4, "name = ?", classname);
                                Toast.makeText(getApplicationContext(), "占用成功", Toast.LENGTH_SHORT).show();
                                break;
                            }
                            else{
                                Toast.makeText(getApplication(), "占用失败", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else if (name.equals(ClassName) && stage.equals("busy")) {
                            Toast.makeText(getApplicationContext(), "该教室已被使用", Toast.LENGTH_SHORT).show();///////////
                            break;
                        }
                    }
                        Intent intent_Occupy_to_roomactivity1 = new Intent(Occupy.this, classroomactivity.class);    //切换Login Activity至User Activity
                        //Bundle bundle2 = new Bundle();
                        //bundle2.putString("name",tmpname);
                        //intent_Occupy_to_roomactivity1.putExtras(bundle2);
                        intent_Occupy_to_roomactivity1.putExtra("user_name1", tmpname);
                        startActivity(intent_Occupy_to_roomactivity1);
                        finish();
                        break;
            }
        }
    };
}


