package com.jmf.mymadeview.customview;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;


import com.jmf.mymadeview.R;
import com.jmf.mymadeview.customview.customview.loginpage.LoginKeyboard;

public class LoginActivity extends Activity {
    public static final String TAG = "KeyBoard";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        LoginKeyboard loginKeyboard = this.findViewById(R.id.number_key_pad);
//        loginKeyboard.setOnKeyPressListener(new LoginKeyboard.OnKeyPressListener() {
//            @Override
//            public void onNumberPress(int number) {
//                Log.d(TAG, "current click value is ==>" + number);
//            }
//
//            @Override
//            public void onBackPress() {
//                Log.d(TAG, "on back press..");
//            }
//        });


    }
}