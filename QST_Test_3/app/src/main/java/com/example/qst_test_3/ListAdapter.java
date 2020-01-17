package com.example.qst_test_3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context mContex;
    List<User> userList;

    public ListAdapter(Context mContex, List<User> userList) {
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
            viewCache.ageTextView = convertView.findViewById(R.id.ageTxt);
            viewCache.mImageView = convertView.findViewById(R.id.itemImg);

            convertView.setTag(viewCache);
        }

        ItemViewCache cache = (ItemViewCache) convertView.getTag();
        cache.mTextView.setText(userList.get(position).getName());
        cache.ageTextView.setText(userList.get(position).getAge());
        cache.mImageView.setImageResource(userList.get(position).getImg());

        return convertView;
    }

    private class ItemViewCache {
        public TextView mTextView;
        public TextView ageTextView;
        public ImageView mImageView;
    }
}
