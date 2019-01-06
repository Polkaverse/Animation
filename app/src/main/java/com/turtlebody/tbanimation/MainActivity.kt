package com.turtlebody.tbanimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.turtlebody.tbanimation.ui.components.anim1.Anim1Activity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        test_btn_anim_circle.setOnClickListener { startActivity<Anim1Activity>()  }
    }
}
