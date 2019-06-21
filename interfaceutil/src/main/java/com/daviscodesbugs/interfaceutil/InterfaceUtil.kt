@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.daviscodesbugs.interfaceutil

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager

object InterfaceUtil {

    fun hideKeyboard(fragment: Fragment?) {
        hideKeyboard(fragment?.activity)
    }

    fun hideKeyboard(activity: Activity?) {
        val view = activity?.currentFocus
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

}