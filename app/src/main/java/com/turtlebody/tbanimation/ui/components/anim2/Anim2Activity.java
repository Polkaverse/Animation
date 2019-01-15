package com.turtlebody.tbanimation.ui.components.anim2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.turtlebody.tbanimation.R;

public class Anim2Activity extends AppCompatActivity {
    CustomView2 customView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim2);

        customView2 = (CustomView2)findViewById(R.id.id_customView2);
        customView2.startAnimate();
    }

}
