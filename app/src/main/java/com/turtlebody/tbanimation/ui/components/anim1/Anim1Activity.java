package com.turtlebody.tbanimation.ui.components.anim1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.turtlebody.tbanimation.R;

import java.text.BreakIterator;
import java.util.Timer;
import java.util.TimerTask;

public class Anim1Activity extends AppCompatActivity {
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim1);

        customView = (CustomView)findViewById(R.id.id_customView);
        customView.startAnimate();
    }

}
