package com.turtlebody.tbanimation.ui.components.anim1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RelativeLayout;
import com.turtlebody.tbanimation.R;

import java.util.Timer;
import java.util.TimerTask;

public class Anim1Activity extends AppCompatActivity {
    private int i = 1;
    CustomView customView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim1);

        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.mylayout);
        customView = new CustomView(this);
        relativeLayout.addView(customView);
        startViewAnimation();
    }

    private void startViewAnimation() {

        final Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (i < 20) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            int baseRadius=20;
                            customView.updateView(15*i+baseRadius);
                            i++;
                        }
                    });
                } else {
                    i = 0;
                }
            }
        }, 0, 1000);
    }
}
