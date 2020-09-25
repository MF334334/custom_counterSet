package com.jmf.mymadeview.customview.customview.loginpage;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.jmf.mymadeview.R;

/*
 * Description:
 * date:2020/9/24 20:36
 */  public class LoginKeyboard extends LinearLayout implements View.OnClickListener {
    private static final String TAG = "LoginKeyborad";
    private OnKeyPressListener mKeyPresslistener =null;

    public LoginKeyboard(Context context) {
        this(context, null);
    }

    public LoginKeyboard(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LoginKeyboard(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //
        LayoutInflater.from(context).inflate(R.layout.num_key_pad, this, true);
        initView();


    }

    private void initView() {
        this.findViewById(R.id.number_0).setOnClickListener(this);
        this.findViewById(R.id.number_1).setOnClickListener(this);
        this.findViewById(R.id.number_2).setOnClickListener(this);
        this.findViewById(R.id.number_3).setOnClickListener(this);
        this.findViewById(R.id.number_4).setOnClickListener(this);
        this.findViewById(R.id.number_5).setOnClickListener(this);
        this.findViewById(R.id.number_6).setOnClickListener(this);
        this.findViewById(R.id.number_7).setOnClickListener(this);
        this.findViewById(R.id.number_8).setOnClickListener(this);
        this.findViewById(R.id.number_9).setOnClickListener(this);
        this.findViewById(R.id.number_delete).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int viewID = v.getId();
        if(viewID ==R.id.number_delete){
            //删除回退键
            Log.d(TAG, "mKeyNumberListener is null not callback..");
            return;
        }else {
            //数字键结果
            String text = ((TextView)v).getText().toString();
            Log.d(TAG, "click text ==>" + text);
            mKeyPresslistener.onNumberPress(Integer.parseInt(text));
        }



    }


    public void setOnKeyPressListener(OnKeyPressListener listener){
        this.mKeyPresslistener = listener;
    }

    public interface OnKeyPressListener{
        void onNumberPress(int number);

        void onBackPress();
    }
}
