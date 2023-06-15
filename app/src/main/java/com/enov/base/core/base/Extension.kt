package com.enov.base.core.base

import android.widget.Button
import android.widget.RelativeLayout
import android.widget.TextView

fun RelativeLayout.setOnPreventFastClickListener(listener: PreventFastClickListener) {
    setOnClickListener(listener)
}
fun TextView.setOnPreventFastClickListener(listener: PreventFastClickListener) {
    setOnClickListener(listener)
}
fun Button.setOnPreventFastClickListener(listener: PreventFastClickListener) {
    setOnClickListener(listener)
}