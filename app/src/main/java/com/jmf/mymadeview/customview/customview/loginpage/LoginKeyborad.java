package com.jmf.mymadeview.customview.customview.loginpage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.jmf.mymadeview.R;

/*
 * Description:
 * date:2020/9/24 20:36
 */   class LoginKeyborad extends LinearLayout {
    public LoginKeyborad(Context context) {
        this(context,null);
    }

    public LoginKeyborad(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LoginKeyborad(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //
        LayoutInflater.from(context).inflate(R.layout.num_key_pad,this,true);
    }
}
