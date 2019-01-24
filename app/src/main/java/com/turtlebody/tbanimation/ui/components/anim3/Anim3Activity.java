package com.turtlebody.tbanimation.ui.components.anim3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.turtlebody.tbanimation.R;
import com.turtlebody.tbanimation.ui.components.anim2.CustomView2;

public class Anim3Activity extends AppCompatActivity {
    CustomView3 customView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim3);

        customView3 = (CustomView3)findViewById(R.id.id_customView3);
        customView3.startAnimate();
    }
}
