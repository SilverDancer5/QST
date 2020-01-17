package com.example.asus.classdemo03;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class LIstActivityDemo extends ListActivity {
    private String[] mLisStr = {"姓名:张三","性别:男"};
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_demo);
        listView = getListView();
        setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,mLisStr));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),mLisStr[i],Toast.LENGTH_SHORT).show();
            }
        });
    }
}
