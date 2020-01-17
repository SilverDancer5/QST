package com.example.qst_test_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity {

    private int[] images = {R.drawable.avocado, R.drawable.biscuit, R.drawable.cake,
            R.drawable.donut, R.drawable.hotdog, R.drawable.macaroon,
            R.drawable.pizza, R.drawable.popsicle, R.drawable.sushi};

    ImageView imageView;
    int curImageID;
    Button backBtn;
    Button nextBtn;
    Button previewBtn;
    GestureDetector mDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDetector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                return false;
            }

            @Override
            public void onShowPress(MotionEvent e) {

            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

                if (e1.getX() - e2.getX() > 50) {
                    nextBtn.performClick();
                    return true;
                }
                if (e2.getX() - e1.getX() > 50) {
                    previewBtn.performClick();
                    return true;
                }
                if (e1.getY() - e2.getY() > 50) {
                    backBtn.performClick();
                    return true;
                }
                if (e2.getY() - e1.getY() > 50) {
                    backBtn.performClick();
                    return true;
                }

                Log.d("TAG", e2.getX() + " " + e2.getY());

                return false;
            }
        });


        imageView = findViewById(R.id.imgview);
        Intent intent = getIntent();
        final int imageID = intent.getIntExtra("image", -1);
        curImageID = imageID;
        imageView.setImageResource(images[curImageID]);

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                mDetector.onTouchEvent(event);
                return true;
            }
        });



        nextBtn = findViewById(R.id.next);
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tempImageID = curImageID;
                if(++tempImageID < images.length) {
                    curImageID = tempImageID;
                    imageView.setImageResource(images[curImageID]);
                } else {
                    Toast.makeText(v.getContext(), "已经到头啦", Toast.LENGTH_SHORT).show();
                    Log.i("Next","" + curImageID);
                }

            }
        });

        previewBtn = findViewById(R.id.preview);
        previewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tempImageID = curImageID;
                if(--tempImageID >= 0) {
                    curImageID = tempImageID;
                    Log.i("Pre","" + curImageID);
                    imageView.setImageResource(images[curImageID]);
                } else {
                    Toast.makeText(v.getContext(), "已经到头啦", Toast.LENGTH_SHORT).show();
                    Log.i("Pre","" + curImageID);
                }
            }
        });



        backBtn = findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

}
