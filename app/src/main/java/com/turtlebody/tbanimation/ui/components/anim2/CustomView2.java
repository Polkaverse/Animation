package com.turtlebody.tbanimation.ui.components.anim2;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.graphics.Rect;

public class CustomView2 extends View{
    //alwasy start variable with small letter
    //alwasy use m for global variable
    //ALL STATIC variable must be in capital later with underscore to separate 2 words

    private Paint mPaint;
    //Rectangle
    private Rect mRect;

    int mRectSize = 350 , p  ;     // p is the Flag Variable
    final static float RECT_MIN_SIDE =350f , RECT_MAX_SIZE =410f;

    //Circle
    int mCircleX = 0, mCircleY = 0;
    final static float CIRCLE_MIN_X =600f , CIRCLE_MAX_X =800f, CIRCLE_RADIUS = 140;

    public CustomView2(Context context) {
        super(context);
        init(null);
    }
    public CustomView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }


    public CustomView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mCircleX = 600;
        mCircleY = 280;

        //initialization must be done only once
        mRect = new Rect();

        mRect.left = 200;
        mRect.top = 200;
        mRect.right = mRectSize;
        mRect.bottom = mRectSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the Rectangle
        canvas.drawRect(mRect, mPaint);
        canvas.drawCircle(mCircleX, mCircleY, CIRCLE_RADIUS, mPaint);
    }

    // Animate Function
    public void startAnimate() {
        // Used ObjectAnimator for Square
        ObjectAnimator first = ObjectAnimator.ofFloat(this, "squareSide", RECT_MIN_SIDE, RECT_MAX_SIZE);
        first.setRepeatCount(ObjectAnimator.INFINITE);
        first.setRepeatMode(ObjectAnimator.REVERSE);

        // Used ObjectAnimator for Circle
        ObjectAnimator second = ObjectAnimator.ofFloat(this, "circleX", CIRCLE_MIN_X, CIRCLE_MAX_X);
        second.setRepeatCount(ObjectAnimator.INFINITE);
        second.setRepeatMode(ObjectAnimator.REVERSE);

        // Animator set to animate two object parallely
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(first,second);
        animatorSet.setDuration(1500);
        animatorSet.start();

    }

    //Circle Getter, Setter and Update Function
    float getCircleX(){
        return 0f;
    }

    void setCircleX(float a ){
        updateCircleView(Math.round(a));
    }
    public void updateCircleView(int side) {
        mCircleX = side;
        invalidate();
    }

    //Square Getter, Setter and Update Function
    float getSquareSide(){
        return 0f;
    }

    void setSquareSide(float a){
        updateSquareView(Math.round(a));
    }

    public void updateSquareView(int side) {
        p=side - mRectSize;
        mRectSize =side ;
        mRect.left = mRect.left -p;
        mRect.top = mRect.top -p ;
        mRect.right = mRectSize;
        mRect.bottom = mRectSize;
        invalidate();
    }

}
