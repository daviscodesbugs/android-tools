package com.daviscodesbugs.androidtools

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_interface_btn.setOnClickListener {
            val intent = Intent(this, InterfaceUtilActivity::class.java)
            startActivity(intent)
        }
    }

}
