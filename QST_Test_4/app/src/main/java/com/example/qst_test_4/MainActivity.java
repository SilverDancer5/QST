package com.example.qst_test_4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    List<Person> personList = new ArrayList();
    ListAdapter listAdapter;
    int itemNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list_person);
        MyDBHelper myDBHelper = new MyDBHelper(this, "per.db", null, 1);
        personList = myDBHelper.select();
        listAdapter = new ListAdapter(this, personList);
        listView.setAdapter(listAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                itemNum = position;
                Person tmpPerson = personList.get(position);
                Intent intent = new Intent(MainActivity.this, DetialActivity.class);
                intent.putExtra("Person", tmpPerson);
                startActivityForResult(intent, 3);
            }
        });




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(1,1,1,"添加");
        menu.add(3,3,3,"退出");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case 1:
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                startActivityForResult(intent, 1);
                break;
            case 3:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setMessage("确认要退出程序吗").setTitle("退出提示");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        MainActivity.this.finish();
                    }
                });

                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

                builder.create().show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 3) {
            Person tmpPerson = (Person) data.getSerializableExtra("Person");
            personList.set(itemNum, tmpPerson);
            listAdapter.notifyDataSetChanged();
            MyDBHelper myDBHelper = new MyDBHelper(this, "per.db", null, 1);
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", tmpPerson.getName());
            contentValues.put("sex", tmpPerson.getSex());
            myDBHelper.update(contentValues, tmpPerson.getID());

        }

        if(resultCode == 1 && requestCode == 1) {
            MyDBHelper myDBHelper = new MyDBHelper(this, "per.db", null, 1);
            personList.clear();
            personList.addAll(myDBHelper.select());
            listAdapter.notifyDataSetChanged();
            Log.i("resultCode", "1========");
        }

        if(resultCode == 2) {
            MyDBHelper myDBHelper = new MyDBHelper(this, "per.db", null, 1);
            personList.clear();
            personList.addAll(myDBHelper.select());
            listAdapter.notifyDataSetChanged();
        }


    }
}
