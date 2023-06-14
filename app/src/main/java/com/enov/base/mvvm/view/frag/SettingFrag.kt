package com.enov.base.mvvm.view.frag

import com.enov.base.R
import com.enov.base.core.base.BaseFragment
import com.enov.base.databinding.FragmentSettingBinding
import com.enov.base.mvvm.vm.SettingFragVM

class SettingFrag: BaseFragment<SettingFragVM, FragmentSettingBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_setting
    }

    override fun initView() {
        binding.vm = viewModel
    }
}