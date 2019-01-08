package com.turtlebody.tbanimation.ui.components.anim1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CustomView extends View {
    Paint paint;
    int radius = 0;

    public CustomView(Context context) {
        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);

    }

    public void updateView(int radius) {
        this.radius = radius;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, radius, paint);
    }

}
