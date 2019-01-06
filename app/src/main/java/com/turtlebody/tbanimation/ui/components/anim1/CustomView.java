package com.turtlebody.tbanimation.ui.components.anim1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class CustomView extends View {
    private Paint paint;

    public CustomView(Context context) {

        super(context);
        paint = new Paint();
        paint.setColor(Color.RED);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        int x = getWidth();
        int y = getHeight();
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(x/2, y/2, 200, paint);
    }
}
