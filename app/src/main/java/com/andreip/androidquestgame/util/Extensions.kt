package com.andreip.androidquestgame.util

import android.app.Activity
import android.content.ComponentName
import android.content.Context
import android.content.pm.PackageManager
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText

fun Context.hideAppIcon(launchActivity: Class<out Activity>) {
    packageManager.setComponentEnabledSetting(
            ComponentName(this, launchActivity),
            PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
            PackageManager.DONT_KILL_APP
    )
}

fun Context.showAppIcon(launchActivity: Class<out Activity>) {
    packageManager.setComponentEnabledSetting(
            ComponentName(this, launchActivity),
            PackageManager.COMPONENT_ENABLED_STATE_ENABLED,
            PackageManager.DONT_KILL_APP
    )
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.invisible() {
    if (visibility != View.INVISIBLE) {
        visibility = View.INVISIBLE
    }
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

/**
 * Hides keyboard and removes focus from EditText
 */
fun EditText.hideKeyboard() {
    //Close keyboard
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)

    // Hide cursor
    isFocusable = false

    // Set EditText to be focusable again
    isFocusable = true
    isFocusableInTouchMode = true
}

fun EditText.showKeyboard() {
    requestFocus()
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}