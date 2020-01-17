package com.example.asus.classdemo03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyListActivity extends AppCompatActivity {

    List<User> userList;
    ListView listView;
    MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_list);
        listView = findViewById(R.id.lv_my_list);
        userList = new ArrayList<>();

        User user1 = new User("张三",R.drawable.beau,"年龄20");
        User user2 = new User("里斯",R.drawable.beau,"年龄18");
        User user3= new User("王五",R.drawable.beau,"年龄19");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);

        myAdapter = new MyAdapter(userList,this);

        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(view.getContext(),userList.get(i).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
