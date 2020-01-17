package com.example.qst_test_1;
import android.content.Context;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatCheckBox;

public class MyCheckBox extends AppCompatCheckBox {
    public  MyCheckBox(Context context) {
        this(context, null);
    }

    public  MyCheckBox(Context context, AttributeSet attrs) {
        this(context, attrs, R.attr.radioButtonStyle);
    }

    public  MyCheckBox(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

}
