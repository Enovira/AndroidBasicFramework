package com.enov.base.mvvm.activity

import com.enov.base.R
import com.enov.base.core.base.BaseActivity
import com.enov.base.databinding.ActivitySubBinding
import com.enov.base.mvvm.activity.vm.SubActVM

class SubActivity: BaseActivity<SubActVM, ActivitySubBinding>() {
    override fun getLayoutId(): Int {
        return R.layout.activity_sub
    }

    override fun initView() {

    }
}