package com.turtlebody.tbanimation.ui.components.anim3;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class CustomView3 extends View {

    private Paint mPaint;
    int mCircleX = 0, mCircleY = 0 , CIRCLE_RADIUS = 70 , CIRCLE2_RADIUS = 60 , mCircleX2 = 215;
    final static float CIRCLE_MIN_R =70f , CIRCLE_MAX_R =110f , CIRCLE2_MIN_X =215f , CIRCLE2_MAX_X =1000f;

    public CustomView3(Context context) {
        super(context);
        init(null);
    }
    public CustomView3(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }
    public CustomView3(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public CustomView3(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(@Nullable AttributeSet attrs) {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mCircleX = 200;
        mCircleY = 280;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleX, mCircleY, CIRCLE_RADIUS, mPaint);

        canvas.drawCircle(mCircleX2, mCircleY, CIRCLE2_RADIUS, mPaint);

    }

    // Animate Function
    public void startAnimate() {

        ObjectAnimator Animat1 = ObjectAnimator.ofFloat(this, "viewAnimation", CIRCLE_MIN_R, CIRCLE_MAX_R);
        Animat1.setRepeatCount(ObjectAnimator.INFINITE);
        Animat1.setRepeatMode(ObjectAnimator.REVERSE);
        Animat1.setDuration(500);

        ObjectAnimator Animat2 = ObjectAnimator.ofFloat(this, "viewAnimationCircle", CIRCLE2_MIN_X, CIRCLE2_MAX_X);
        Animat2.setRepeatCount(ObjectAnimator.INFINITE);
        Animat2.setRepeatMode(ObjectAnimator.RESTART);
        Animat2.setDuration(4000);

        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playTogether(Animat1, Animat2);
        animatorSet2.start();

    }


    float getViewAnimationCircle(){
        return 0f;
    }

    void setViewAnimationCircle(float a )
    {
        updateAnimationCircleView(Math.round(a));
    }

    private void updateAnimationCircleView(int xaxis) {
        if(xaxis==230){
            CIRCLE2_RADIUS=60;
        }
        mCircleX2 = xaxis;
        if (mCircleX2>950){
            CIRCLE2_RADIUS=CIRCLE2_RADIUS-1;
        }
        invalidate();
    }


    float getViewAnimation(){
        return 0f;
    }

    void setViewAnimation(float a )
    {
        updateAnimationView(Math.round(a));
    }

    private void updateAnimationView(int radius) {
        CIRCLE_RADIUS = radius;
        invalidate();
    }
}
