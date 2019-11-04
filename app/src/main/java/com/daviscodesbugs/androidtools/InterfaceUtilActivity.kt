package com.daviscodesbugs.androidtools

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.daviscodesbugs.interfaceutil.InterfaceUtil
import kotlinx.android.synthetic.main.activity_interface_util.*
import kotlin.concurrent.thread

class InterfaceUtilActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_interface_util)

        interface_util_keyboard.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (hasFocus) { hideKeyboardLater() }
        }
        interface_util_keyboard.setOnClickListener { hideKeyboardLater() }
    }

    private fun hideKeyboardLater() {
        thread {
            Thread.sleep(3000)
            InterfaceUtil.hideKeyboard(this)
        }
    }

}