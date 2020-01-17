package com.example.qst_test_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class DetialActivity extends AppCompatActivity {

    Button addBtn;
    EditText nameText;
    EditText ageText;
    ArrayList<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        nameText = findViewById(R.id.name_text);
        ageText = findViewById(R.id.age_Text);

        addBtn = findViewById(R.id.add_btn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetialActivity.this, ListActivity.class);
                User tmpUser = new User("姓名："+nameText.getText(), "年龄："+ageText.getText(), R.drawable.popsicle);

                intent.putExtra("newUser", tmpUser);

                setResult(0, intent);
                finish();
            }
        });
    }
}
