package com.turtlebody.tbanimation.ui.components.anim1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.turtlebody.tbanimation.R;

import java.text.BreakIterator;
import java.util.Timer;
import java.util.TimerTask;

public class Anim1Activity extends AppCompatActivity {
    private int i = 14 , j=1, k=1;
    CustomView customView;
    public int baseRadius=20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim1);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.mylayout);
        customView = new CustomView(this);
        relativeLayout.addView(customView);
        customView.startAnimate();
    }

}
