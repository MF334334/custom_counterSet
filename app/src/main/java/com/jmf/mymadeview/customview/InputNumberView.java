package com.jmf.mymadeview.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.jmf.mymadeview.R;


/*
 * Description:自定义InputNumberView
 * date:2020/9/20 11:33
 */
public class InputNumberView extends RelativeLayout {

    private static final String TAG = "InputNumberView";
    private View mMinusBtn;
    private View mPlusBtn;
    private EditText valueEdt;
    private int mCurrentNumber = 0;

    int mMax;
    int mMin;
    int mStep;
    int mDefaultValue;
    boolean mDisable;
    int mBtnBgRes;

    private onNumberChangeListener mOnNumberChangeListener;

    public InputNumberView(Context context) {
        this(context, null);
    }

    public InputNumberView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);

    }


    public InputNumberView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View view = LayoutInflater.from(context).inflate(R.layout.input_number_view, this, false);
        addView(view);

        //初始化控件属性
        initAttrs(context, attrs);
        //处理事件
        initView();
        //设置事件
        setUpEvent();


    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.InputNumberView);
        mMax = a.getInt(R.styleable.InputNumberView_max, 0);
        mMin = a.getInt(R.styleable.InputNumberView_min, 0);
        mStep = a.getInt(R.styleable.InputNumberView_step, 0);
        mDefaultValue = a.getInt(R.styleable.InputNumberView_defaultValue, 0);
        this.mCurrentNumber = mDefaultValue;
        mDisable = a.getBoolean(R.styleable.InputNumberView_disable, false);
        mBtnBgRes = a.getResourceId(R.styleable.InputNumberView_btnBackground, -1);
        //自定义数据绑定

        Log.d(TAG, "mMax == >" + mMax);
        Log.d(TAG, "mMin == >" + mMin);
        Log.d(TAG, "mStep == >" + mStep);
        Log.d(TAG, "mStep == >" + mStep);
        Log.d(TAG, "mDefaultValue == >" + mDefaultValue);
        Log.d(TAG, "mDisable == >" + mDisable);
        Log.d(TAG, "mBtnBgRes == >" + mBtnBgRes);

        a.recycle(); //回收
    }

    private void initView() {
        mMinusBtn = this.findViewById(R.id.minus_btn);
        valueEdt = this.findViewById(R.id.value_edt);
        mPlusBtn = this.findViewById(R.id.plus_btn);

        updateText();
        //初始化控件值
        mMinusBtn.setEnabled(mDisable);
        mPlusBtn.setEnabled(mDisable);
    }

    private void setUpEvent() {
        mMinusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mPlusBtn.setEnabled(true);
                mCurrentNumber -= mStep;
                if (mMin !=0 && mCurrentNumber <= mMin) {
                    v.setEnabled(false);//低于最小，禁止点击
                    mCurrentNumber = mMin; //超出最小边界重置
                    Log.d(TAG, "current min value is..");
                    if(mOnNumberChangeListener!=null){
                        mOnNumberChangeListener.onMin(getmMin());
                    }

                }
                updateText();
            }
        });
        mPlusBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentNumber += mStep;
                mMinusBtn.setEnabled(true);
                if (mMax != 0 && mCurrentNumber >= mMax) {
                    v.setEnabled(false);
                    mCurrentNumber = mMax; //超出最大边界重置
                    Log.d(TAG, "current max value is...");
                    if(mOnNumberChangeListener!=null){
                        mOnNumberChangeListener.onMax(mMax);
                    }

                }

                updateText();
            }
        });
    }


    public int getmCurrentNumber() {
        return mCurrentNumber;
    }

    public void setmCurrentNumber(int value) {
        this.mCurrentNumber = value;
        this.updateText();
    }

    private void updateText() {
//        正数限制
//        mCurrentNumber = mCurrentNumber < 0 ? 0 : mCurrentNumber;
        valueEdt.setText(String.valueOf(mCurrentNumber));
        if (mOnNumberChangeListener != null) {
            mOnNumberChangeListener.onNumberchange(this.mCurrentNumber);

        }
    }

    public void setOnNumberChangeListener(onNumberChangeListener listener) {
        this.mOnNumberChangeListener = listener;
    }

    public interface onNumberChangeListener {
        void onNumberchange(int value);

        void onMax(int Max);

        void onMin(int Min);

    }

    public int getmMax() {
        return mMax;
    }

    public void setmMax(int mMax) {
        this.mMax = mMax;
    }

    public int getmMin() {
        return mMin;
    }

    public void setmMin(int mMin) {
        this.mMin = mMin;
    }

    public int getmStep() {
        return mStep;
    }

    public void setmStep(int mStep) {
        this.mStep = mStep;
    }

    public int getmDefaultValue() {
        return mDefaultValue;
    }

    public void setmDefaultValue(int mDefaultValue) {
        this.mDefaultValue = mDefaultValue;
        this.mCurrentNumber = mDefaultValue;
        this.updateText();
    }

    public boolean ismDisable() {
        return mDisable;
    }

    public void setmDisable(boolean mDisable) {
        this.mDisable = mDisable;
    }

    public int getmBtnBgRes() {
        return mBtnBgRes;
    }

    public void setmBtnBgRes(int mBtnBgRes) {
        this.mBtnBgRes = mBtnBgRes;
    }

    public View getmMinusBtn() {
        return mMinusBtn;
    }

    public void setmMinusBtn(View mMinusBtn) {
        this.mMinusBtn = mMinusBtn;
    }
}
