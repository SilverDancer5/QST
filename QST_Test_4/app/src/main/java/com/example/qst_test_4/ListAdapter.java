package com.example.qst_test_4;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context mContex;
    List<Person> personList;

    public ListAdapter(Context mContex, List<Person> personList) {
        this.mContex = mContex;
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return personList.size();
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

            viewCache.idTextView = convertView.findViewById(R.id.id_Txt);
            viewCache.nameTextView = convertView.findViewById(R.id.name_Txt);
            viewCache.sexTextView = convertView.findViewById(R.id.sex_Txt);

            convertView.setTag(viewCache);
        }

        ItemViewCache cache = (ItemViewCache) convertView.getTag();
        cache.idTextView.setText("    ID:    " + personList.get(position).getID());
        cache.nameTextView.setText("姓名:    " + personList.get(position).getName());
        cache.sexTextView.setText("性别:    " + personList.get(position).getSex());

        return convertView;
    }

    private class ItemViewCache {
        public TextView idTextView;
        public TextView nameTextView;
        public TextView sexTextView;

    }
}
