package com.example.qst_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int[] mImages = {R.drawable.avocado, R.drawable.biscuit, R.drawable.cake,
            R.drawable.donut, R.drawable.hotdog, R.drawable.macaroon,
            R.drawable.pizza, R.drawable.popsicle, R.drawable.sushi};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        GridView gridView = findViewById(R.id.gridview);
        GridViewAdapter gridViewAdapter = new GridViewAdapter(this, mImages);
        gridView.setAdapter(gridViewAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);

                intent.putExtra("image", position);
                startActivity(intent);
            }
        });
    }
}
