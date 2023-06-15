package com.enov.base.core.base

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import com.enov.base.R

class TitleBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    RelativeLayout(context, attrs, defStyleAttr) {
        private lateinit var titleBarLeft: RelativeLayout
        private lateinit var titleBarCenter: TextView
        private lateinit var titleBarRight: TextView
        private var delegate: Delegate? = null

    init {
        inflate(context, R.layout.view_title_bar, this)
        initView()
        initListener()
        initAttrs(context, attrs)
    }

    private fun initView() {
        titleBarLeft = findViewById(R.id.title_bar_left)
        titleBarCenter = findViewById(R.id.title_bar_center)
        titleBarRight = findViewById(R.id.title_bar_right)
    }

    private fun initListener() {
        titleBarLeft.setOnPreventFastClickListener(object : PreventFastClickListener() {
            override fun onPreventFastClickListener(view: View?) {
                delegate?.onClickLeft()
            }
        })
        titleBarRight.setOnPreventFastClickListener(object : PreventFastClickListener() {
            override fun onPreventFastClickListener(view: View?) {
                delegate?.onClickRight()
            }
        })
    }

    private fun initAttrs(context: Context, attrs: AttributeSet?) {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar)
        for (i in 0 until typedArray.indexCount) {
            initAttr(typedArray, typedArray.getIndex(i))
        }
        typedArray.recycle()
    }

    private fun initAttr(typedArray: TypedArray, attr: Int) {
        when(attr) {
            R.styleable.TitleBar_title -> titleBarCenter.text = typedArray.getText(attr)
            R.styleable.TitleBar_leftVisible -> titleBarLeft.visibility = typedArray.getInt(attr, View.GONE)
            R.styleable.TitleBar_rightVisible -> titleBarRight.visibility = typedArray.getInt(attr, View.GONE)
            R.styleable.TitleBar_rightText-> titleBarRight.text = typedArray.getText(attr)
        }
    }

    interface Delegate {
            fun onClickLeft()
            fun onClickRight()
        }

    fun setDelegate(delegate: Delegate) {
        this.delegate = delegate
    }
}