@file:Suppress("unused", "MemberVisibilityCanBePrivate")

package com.daviscodesbugs.interfaceutil

import android.app.Activity
import android.content.Context
import android.content.DialogInterface
import android.support.v4.app.Fragment
import android.view.inputmethod.InputMethodManager
import android.widget.ArrayAdapter

object InterfaceUtil {

    fun hideKeyboard(fragment: Fragment?) {
        hideKeyboard(fragment?.activity)
    }

    fun hideKeyboard(activity: Activity?) {
        val view = activity?.currentFocus
        val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.hideSoftInputFromWindow(view?.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }

    fun confirmationDialog(
        context: Context?,
        title: String,
        message: String,
        confirm: String,
        cancel: String,
        handler: DialogInterface.OnClickListener
    ): android.app.AlertDialog {
        val builder = android.app.AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(confirm, handler)
        builder.setNegativeButton(cancel) { _, _ -> }
        return builder.create()
    }

    fun confirmationDialog(
        context: Context,
        title: String,
        message: String,
        confirm: String,
        cancel: String,
        handler: DialogInterface.OnClickListener
    ): android.support.v7.app.AlertDialog {
        val builder = android.support.v7.app.AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        builder.setPositiveButton(confirm, handler)
        builder.setNegativeButton(cancel) { _, _ -> }
        return builder.create()
    }

    fun <T> makeDropDownAdapter(
        context: Context?,
        list: List<T>?
    ): ArrayAdapter<T>? {
        return context?.run {
            val adapter = ArrayAdapter(this, R.layout.spinner_item, list ?: ArrayList())
            adapter.setDropDownViewResource(R.layout.spinner_item)
            adapter
        }
    }

    fun <T> makeDropDownAdapter(
        context: Context?,
        layoutResource: Int,
        list: List<T>?
    ): ArrayAdapter<T>? {
        return context?.run {
            val adapter = ArrayAdapter(this, layoutResource, list ?: ArrayList())
            adapter.setDropDownViewResource(R.layout.spinner_item)
            adapter
        }
    }

}