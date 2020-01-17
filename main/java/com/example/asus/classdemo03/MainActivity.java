package com.example.asus.classdemo03;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_contxt_menu);
        registerForContextMenu(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
//        menu.add("菜单一");
//        menu.add("菜单二");
//        menu.add("菜单三");

//        menu.add(1,1,1,"菜单一");
//        menu.add(1,2,2,"菜单二");
//        menu.add(2,3,1,"菜单三");
//        menu.add(2,4,2,"菜单四");

        SubMenu subMenu = menu.addSubMenu(1,5,1,"基础操作");

        MenuItem menuItem = subMenu.add(1,1,1,"菜单一");
        menuItem.setIcon(android.R.drawable.ic_menu_add);

        subMenu.add(1,2,2,"菜单二");
        subMenu.add(2,3,1,"菜单三");
        subMenu.add(2,4,2,"菜单四");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.i("onOptionsItemSelected",item.getItemId()+"");
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("组件操作");
        menu.add(1,1,1,"删除");
        menu.add(1,2,3,"修改");
        menu.add(1,3,2,"添加");
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Log.i("onContextItemSelected",item.getItemId()+"");
        return super.onContextItemSelected(item);
    }
}
