package com.bamboolmc.zhiqu.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bamboolmc.zhiqu.R;
import com.bamboolmc.zhiqu.util.UiUtil;

/**
 * Created by limc on 17/5/2.
 * 可扩展TextView
 */
public class ExpandTextView extends LinearLayout {

    protected TextView mContentView;
    protected ImageView mExpandView;

    //styleable属性
    protected int textColor;
    protected float textSize;
    protected int maxLine;
    protected String text;

    //默认属性
    public int defaultTextColor = Color.BLACK;
    public int defaultTextSize = 14;
    public int defaultLine = 3;


    public ExpandTextView(Context context) {
        super(context);
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(context, attrs);
        bindListener();
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void init() {
        //垂直布局、中间对齐
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);

        //行距;长、高度设置
        mContentView = new TextView(getContext());
        mContentView.setLineSpacing(1f, 1.3f);
        addView(mContentView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        //向下箭头初始化添加
        mExpandView = new ImageView(getContext());
        int padding = UiUtil.dp2px(getContext(), 5);
        mExpandView.setPadding(padding, padding, padding, padding);
        mExpandView.setImageResource(R.drawable.ic_arrow_down);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        addView(mExpandView, llp);
    }

    private void initWithAttrs(Context context, AttributeSet attrs) {
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.ExpandTextView);
        textColor = array.getColor(R.styleable.ExpandTextView_textColor, defaultTextColor);
        textSize = array.getDimensionPixelSize(R.styleable.ExpandTextView_textSize, defaultTextSize);
        maxLine = array.getInt(R.styleable.ExpandTextView_maxLine, defaultLine);
        text = array.getString(R.styleable.ExpandTextView_text);
        bindTextView(textColor, textSize, maxLine, text);
        array.recycle();
    }

    private void bindListener() {
        setOnClickListener(new View.OnClickListener() {
            boolean isExpand;

            @Override
            public void onClick(View v) {
                isExpand = !isExpand;
                mContentView.clearAnimation();
                final int deltaValue;
                final int startValue = mContentView.getHeight();
                int durationMillis = 350;
                if (isExpand) {
                    deltaValue = mContentView.getLineHeight() * mContentView.getLineCount() - startValue;
                    RotateAnimation animation = new RotateAnimation(0, 180, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    mExpandView.startAnimation(animation);
                } else {
                    deltaValue = mContentView.getLineHeight() * maxLine - startValue;
                    RotateAnimation animation = new RotateAnimation(180, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                    animation.setDuration(durationMillis);
                    animation.setFillAfter(true);
                    mExpandView.startAnimation(animation);
                }
                Animation animation = new Animation() {
                    protected void applyTransformation(float interpolatedTime, Transformation t) {
                        mContentView.setHeight((int) (startValue + deltaValue * interpolatedTime));
                    }

                };
                animation.setDuration(durationMillis);
                mContentView.startAnimation(animation);

            }
        });
    }

    private void bindTextView(int textColor, float textSize, int maxLine, String text) {
        mContentView.setTextColor(textColor);
        mContentView.setTextSize(TypedValue.COMPLEX_UNIT_PX, textSize);
        mContentView.setText(text);
        mContentView.setHeight(mContentView.getLineHeight() * maxLine);
    }

    public TextView getTextView(){
        return mContentView;
    }

    public void setText(CharSequence charSequence){
        mContentView.setText(charSequence);
    }
}
