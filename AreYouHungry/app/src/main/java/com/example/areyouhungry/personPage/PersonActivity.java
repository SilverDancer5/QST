package com.example.areyouhungry.personPage;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.areyouhungry.R;
import com.example.areyouhungry.lifePage.LifeActivity;
import com.example.areyouhungry.takeoutPage.Database;
import com.example.areyouhungry.takeoutPage.FreeSendActivity;
import com.example.areyouhungry.takeoutPage.FruitShopActivity;
import com.example.areyouhungry.takeoutPage.MyListView;
import com.example.areyouhungry.takeoutPage.MyScrollView;
import com.example.areyouhungry.takeoutPage.SearchActivity;
import com.example.areyouhungry.takeoutPage.Shoper;
import com.example.areyouhungry.takeoutPage.ShoperActivity;
import com.example.areyouhungry.takeoutPage.ShoperAdapter;
import com.example.areyouhungry.takeoutPage.ad1Activity;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class PersonActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.person_layout, null);
        return view;
    }

}