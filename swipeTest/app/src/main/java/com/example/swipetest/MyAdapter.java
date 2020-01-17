package com.example.swipetest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context mContex;
    List<User> userList;

    public MyAdapter(Context mContex, List<User> userList) {
        this.mContex = mContex;
        this.userList = userList;
    }


    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContex).inflate(R.layout.myitem, null);

            ItemViewCache viewCache = new ItemViewCache();

            viewCache.mTextView = convertView.findViewById(R.id.itemTxt);

            convertView.setTag(viewCache);
        }

        ItemViewCache cache = (ItemViewCache) convertView.getTag();
        cache.mTextView.setText(userList.get(position).getName());


        return convertView;
    }

    private class ItemViewCache {
        public TextView mTextView;

    }
}