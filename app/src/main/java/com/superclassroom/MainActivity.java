package com.superclassroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;

    private GridView detailCource;

    private MyAdapter adapter;

    private String[][] contents;

    private AbsGridAdapter secondAdapter;

    private List<String> dataList;

    private ArrayAdapter<String> spinnerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cource);
        spinner = (Spinner)findViewById(R.id.switchWeek);
        detailCource = (GridView)findViewById(R.id.courceDetail);
        ///////////////第一种方式创建Adapater
//        List<String> list = init();
//        adapter = new MyAdapter(this, list);
//        detailCource.setAdapter(adapter);
        ///////////////第二种方式创建Adapter
        fillStringArray();
        secondAdapter = new AbsGridAdapter(this);
        secondAdapter.setContent(contents, 6, 7);
        detailCource.setAdapter(secondAdapter);
        //////////////创建Spinner数据
        fillDataList();
        spinnerAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, dataList);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }

    /**
     * 准备数据
     */
    private List<String> init() {
        List<String> list = new ArrayList<String>();
        list.add("现代测试技术B211");
        list.add("数据结构与算法B211");
        list.add("微机原理及应用E203");
        list.add("面向对象程序设计A309");
        list.add("数据结构与算法B207");
        list.add("");
        list.add("");
        list.add("微机原理及应用E203");
        list.add("");
        list.add("电磁场理论A212");
        list.add("传感器电子测量A\nC309");
        list.add("微机原理及应用E203");
        list.add("");
        list.add("");
        list.add("电磁场理论A212");
        list.add("面向对象程序设计A309");
        list.add("现代测试技术B211");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("传感器电子测量A\nC309");
        list.add("面向对象程序设计A309");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        return list;
    }

    public void fillStringArray() {
        contents = new String[6][7];
        contents[0][0] = "现代测试技术\n302-302";
        contents[1][0] = "微机原理及应用\n301-302";
        contents[2][0] = "";
        contents[3][0] = "";
        contents[4][0] = "软件工程\n301-301";
        contents[5][0] = "软件工程\n301-301";
        contents[0][1] = "数据结构与算法\n302-303";
        contents[1][1] = "";
        contents[2][1] = "面向对象程序设计\n301-302";
        contents[3][1] = "面向对象程序设计\n301-302";
        contents[4][1] = "";
        contents[5][1] = "";
        contents[0][2] = "微机原理及应用\n301-302";
        contents[1][2] = "电磁场理论\n305-303";
        contents[2][2] = "";
        contents[3][2] = "";
        contents[4][2] = "";
        contents[5][2] = "";
        contents[0][3] = "面向对象程序设计\n301-302";
        contents[1][3] = "传感器电子测量A\n305-301";
        contents[2][3] = "";
        contents[3][3] = "";
        contents[4][3] = "电磁场理论\n305-303";
        contents[5][3] = "操作系统\n301-301";
        contents[0][4] = "数据结构与算法\n302-303";
        contents[1][4] = "微机原理及应用\n301-302";
        contents[2][4] = "";
        contents[3][4] = "";
        contents[4][4] = "";
        contents[5][4] = "";
        contents[0][5] = "";
        contents[1][5] = "";
        contents[2][5] = "现代测试技术\n302-302";
        contents[3][5] = "传感器电子测量A\n305-301";
        contents[4][5] = "";
        contents[5][5] = "";
        contents[0][6] = "";
        contents[1][6] = "";
        contents[2][6] = "";
        contents[3][6] = "";
        contents[4][6] = "";
        contents[5][6] = "";
    }

    public void fillDataList() {
        dataList = new ArrayList<>();
        for(int i = 1; i < 21; i++) {
            dataList.add("第" + i + "周");
        }
    }
}