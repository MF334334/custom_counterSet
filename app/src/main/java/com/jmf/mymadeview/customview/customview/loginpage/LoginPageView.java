package com.jmf.mymadeview.customview.customview.loginpage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;

import androidx.annotation.Nullable;

import com.jmf.mymadeview.R;


/*
 * Description:
 * date:2020/9/28 10:26
 */   class LoginPageView extends FrameLayout {
    public LoginPageView(Context context) {
        this(context, null);
    }

    public LoginPageView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginPageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取属性
        initAttrs(context, attrs);
        //初始化控件
        initView();


    }

    private void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.login_page_view,this);
    }

    private void initAttrs(@Nullable Context context,@Nullable AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LoginPageView);
        int color = a.getColor(R.styleable.LoginPageView_mainColor,-1);
        int VerifyCodeSize = a.getInt(R.styleable.LoginPageView_verifyCodeSize,4);
        //回收
        a.recycle();
    }


}
