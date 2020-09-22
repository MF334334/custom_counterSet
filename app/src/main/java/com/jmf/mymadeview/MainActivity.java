package com.jmf.mymadeview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.jmf.mymadeview.customview.InputNumberView;


public class MainActivity extends Activity implements InputNumberView.onNumberChangeListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        InputNumberView inputNumberView = this.findViewById(R.id.input_NumberView);
        inputNumberView.setOnNumberChangeListener(this);
    }


    @Override
    public void onNumberchange(int value) {
        Log.d(TAG, "current value is == >" + value);
    }

    @Override
    public void onMax(int Max) {
        Log.d(TAG, "reach the Max value！！" + Max);
    }

    @Override
    public void onMin(int Min) {
        Log.d(TAG, "reach the Min value " + Min);

    }
}