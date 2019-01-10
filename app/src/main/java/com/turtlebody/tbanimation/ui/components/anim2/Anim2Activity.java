package com.turtlebody.tbanimation.ui.components.anim2;

import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.PathInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.turtlebody.tbanimation.R;
import com.turtlebody.tbanimation.ui.components.anim1.CustomView;

import java.util.Timer;
import java.util.TimerTask;

public class Anim2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim2);

    }

}
