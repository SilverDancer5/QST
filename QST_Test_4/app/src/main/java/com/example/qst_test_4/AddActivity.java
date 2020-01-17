package com.example.qst_test_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    EditText nameText;
    EditText sexText;

    Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);


        nameText = findViewById(R.id.name_add_Text);
        sexText = findViewById(R.id.sex_add_Text);
        addBtn = findViewById(R.id.add_btn);


        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper myDBHelper = new MyDBHelper(v.getContext(), "per.db", null, 1);
                ContentValues contentValues = new ContentValues();
                String addName = nameText.getText().toString();
                String addSex = sexText.getText().toString();
                contentValues.put("name", addName);
                contentValues.put("sex", addSex);
                myDBHelper.add(contentValues);
                setResult(1);
                finish();
            }
        });

    }
}
