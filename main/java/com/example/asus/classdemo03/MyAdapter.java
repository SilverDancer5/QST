package com.example.asus.classdemo03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    List<User> userList;
    Context mContext;

    public MyAdapter(List<User> list,Context context){
        userList = list;
        mContext = context;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(mContext).inflate(R.layout.my_item,null);
        ImageView user_img = view.findViewById(R.id.iv_user_img);
        TextView user_name = view.findViewById(R.id.tv_user_name);
        TextView user_age = view.findViewById(R.id.tv_user_age);
        user_img.setImageDrawable(mContext.getResources().getDrawable(userList.get(i).getImg()));
        user_name.setText(userList.get(i).getName());
        user_age.setText(userList.get(i).getAge());
        return view;
    }
}
