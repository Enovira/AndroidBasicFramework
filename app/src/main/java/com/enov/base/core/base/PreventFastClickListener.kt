package com.enov.base.core.base

import android.view.View

abstract class PreventFastClickListener: View.OnClickListener {

    private val period: Long = 600 // 点击间隔600ms
    private var lastClickTime: Long = 0 // 最后一次点击时间

    override fun onClick(v: View?) {
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime > period) {
            lastClickTime = currentTime
            onPreventFastClickListener(v)
        }
    }

    abstract fun onPreventFastClickListener(view: View?)
}