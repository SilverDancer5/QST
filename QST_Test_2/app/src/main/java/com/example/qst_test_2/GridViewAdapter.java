package com.example.qst_test_2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewAdapter extends BaseAdapter {

    private Context mContex;
    private int[] mImages;

    public GridViewAdapter(Context mContex, int[] mImages) {
        this.mContex = mContex;
        this.mImages = mImages;
    }


    @Override
    public int getCount() {
        return mImages.length;
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
        ImageView imgView;
        if(convertView == null) {
            imgView = new ImageView(mContex);
            imgView.setLayoutParams(new GridView.LayoutParams(200, 200));
            imgView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imgView.setPadding(8, 8, 8, 8);
        } else {
            imgView = (ImageView) convertView;

        }
        imgView.setImageResource(mImages[position]);
        return imgView;
    }
}