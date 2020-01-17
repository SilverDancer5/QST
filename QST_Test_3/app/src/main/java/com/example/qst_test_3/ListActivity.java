package com.example.qst_test_3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView mListView = null;
    ArrayList<User> userList;
    ListAdapter listAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mListView = findViewById(R.id.list_user);

        User user1 = new User("姓名：韩悦民", "年龄：20", R.drawable.popsicle);
        User user2 = new User("姓名：范泱鋆", "年龄：20", R.drawable.popsicle);

        userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);

        listAdapter = new ListAdapter(this, userList);
        mListView.setAdapter(listAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {


                AlertDialog.Builder builder = new AlertDialog.Builder(ListActivity.this);
                String tmpName = userList.get(i).getName();
                String tmpAge = userList.get(i).getAge();
                String tmpMessage = "名字："+tmpName+"\n年龄：" + tmpAge;
                builder.setMessage(tmpMessage).setTitle("用户信息");
                builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.create().show();


            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        menu.add(1,1,1,"添加");
        menu.add(2,2,2,"返回");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                Intent intent = new Intent(ListActivity.this, DetialActivity.class);
                startActivityForResult(intent, 0);
                break;
            case 2:
                finish();
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //TODO
        User tmpUser = (User) data.getSerializableExtra("newUser");
        Log.i("User", "新用户名："+ tmpUser.getName());
        userList.add(tmpUser);
        listAdapter.notifyDataSetChanged();

    }
}
