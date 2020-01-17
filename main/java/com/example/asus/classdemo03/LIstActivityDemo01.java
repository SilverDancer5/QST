package com.example.asus.classdemo03;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LIstActivityDemo01 extends AppCompatActivity {
    private String[] mLisStr = {"姓名:张三","性别:男"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo01);
        listView = findViewById(R.id.lv_mylist01);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mLisStr));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),mLisStr[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
