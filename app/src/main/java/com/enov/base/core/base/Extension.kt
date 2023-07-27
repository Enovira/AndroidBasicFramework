package com.enov.base.core.base

import android.view.View

fun View.setOnPreventFastClickListener(listener: PreventFastClickListener) {
    setOnClickListener(listener)
}