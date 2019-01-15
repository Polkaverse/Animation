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
    private Rect rectangle;
    private Paint paint;
    int x = 200;
    int y = 200;
    int sideLength = 350   , p  ;
    final static float Sidemin=350f , Sidemax=410f;

    // Variable for Circle

    int Circle_X_Axis = 0, Circle_Y_Axis = 0  , x_axis=0;
    final static float Circle_X_Axis1=600f , Circle_X_Axis2=800f;

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
        paint = new Paint();
        paint.setColor(Color.RED);
        Circle_X_Axis = 600;
        Circle_Y_Axis = 280;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Draw the Rectangle
        rectangle = new Rect(x, y, sideLength, sideLength);
        canvas.drawRect(rectangle, paint);

        //Draw the Circle
        canvas.drawCircle(Circle_X_Axis, Circle_Y_Axis, 140, paint);

    }

        // Animate Function

    public void startAnimate() {
                          // Used ObjectAnimator for Square
        ObjectAnimator first = ObjectAnimator.ofFloat(this, "squareSide", Sidemin, Sidemax);
        first.setRepeatCount(ObjectAnimator.INFINITE);
        first.setRepeatMode(ObjectAnimator.REVERSE);

                        // Used ObjectAnimator for Circle
        ObjectAnimator second = ObjectAnimator.ofFloat(this, "circleX", Circle_X_Axis1, Circle_X_Axis2);
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
        Circle_X_Axis = side;
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
        p=side - sideLength ;
        this.sideLength =side ;
        this.x =x-p;
        this.y =y-p ;
        invalidate();
    }

}
