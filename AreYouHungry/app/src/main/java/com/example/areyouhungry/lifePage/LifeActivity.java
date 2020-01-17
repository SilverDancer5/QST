package com.example.areyouhungry.lifePage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.areyouhungry.R;
import com.example.areyouhungry.takeoutPage.MyScrollView;

public class LifeActivity extends Fragment implements MyScrollView.MyScrollViewListener {
    MyScrollView sr_view;
    TextView your_block;
    ImageView img_head;
    int height;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.life_layout, null);
        sr_view = view.findViewById(R.id.sr_view);
        your_block = view.findViewById(R.id.your_block);
        img_head = view.findViewById(R.id.img_head);
        getHetght();
        return view;
    }


    private void getHetght() {

        ViewTreeObserver vto = img_head.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                height = img_head.getHeight();
                sr_view.setScrollViewListener(LifeActivity.this);
            }
        });
    }

    @Override
    public void onScrollChanged(MyScrollView scrollView, int x, int y, int oldx, int oldy) {
        if (y <= 400) {
            your_block.setVisibility(View.INVISIBLE);
        } else {
            your_block.setVisibility(View.VISIBLE);
        }
    }
}
