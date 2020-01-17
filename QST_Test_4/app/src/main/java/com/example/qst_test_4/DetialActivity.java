package com.example.qst_test_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetialActivity extends AppCompatActivity {

    int hasMod = 0;

    Button backBtn;
    Button modBtn;
    Button delBtn;

    EditText IDText;
    EditText nameText;
    EditText sexText;
    EditText nameModText;
    EditText sexModText;



    TextView nameModTV;
    TextView sexModTV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detial);

        final Person person = (Person) getIntent().getSerializableExtra("Person");


        IDText = findViewById(R.id.ID_text);
        nameText = findViewById(R.id.name_Text);
        sexText = findViewById(R.id.sex_Text);
        nameModText = findViewById(R.id.name_mod_Text);
        sexModText = findViewById(R.id.sex_mod_Text);
        nameModTV = findViewById(R.id.name_mod_TextView);
        sexModTV = findViewById(R.id.sex_mod_TextView);


        IDText.setText(person.getID()+"");
        nameText.setText(person.getName()+"");
        sexText.setText(person.getSex()+"");


        delBtn = findViewById(R.id.delete_btn);
        delBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDBHelper myDBHelper = new MyDBHelper(v.getContext(), "per.db", null, 1);
                myDBHelper.delete(person.getID());
                setResult(2);
                finish();
            }
        });


        modBtn = findViewById(R.id.modify_btn);
        modBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameModTV.setVisibility(View.VISIBLE);
                nameModText.setVisibility(View.VISIBLE);
                sexModTV.setVisibility(View.VISIBLE);
                sexModText.setVisibility(View.VISIBLE);
                delBtn.setVisibility(View.GONE);
                modBtn.setVisibility(View.GONE);


                nameModText.setText(nameText.getText());
                sexModText.setText(sexText.getText());

                hasMod = 1;
            }
        });


        backBtn = findViewById(R.id.back_btn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hasMod == 1) {
                    int rtnID = Integer.parseInt(IDText.getText().toString());
                    String rtnName = nameModText.getText().toString();
                    String rtnSex = sexModText.getText().toString();
                    Person rtnPerson = new Person(rtnID, rtnName, rtnSex);

                    Intent rtnIntent = new Intent(DetialActivity.this, MainActivity.class);
                    rtnIntent.putExtra("Person", rtnPerson);
                    setResult(3, rtnIntent);
                    hasMod = 0;
                    Log.i("tmpPerson", "" + rtnPerson.getName()+"");
                    finish();
                } else {
                    hasMod = 0;

                    int rtnID = Integer.parseInt(IDText.getText().toString());
                    String rtnName = nameText.getText().toString();
                    String rtnSex = sexText.getText().toString();
                    Person rtnPerson = new Person(rtnID, rtnName, rtnSex);

                    Intent rtnIntent = new Intent(DetialActivity.this, MainActivity.class);
                    rtnIntent.putExtra("Person", rtnPerson);
                    setResult(3, rtnIntent);
                    hasMod = 0;
                    Log.i("tmpPerson", "" + rtnPerson.getName()+"");
                    finish();
                }
            }
        });

    }
}
