package com.enov.base.mvvm.fragment

import com.enov.base.R
import com.enov.base.core.base.BaseFragment
import com.enov.base.databinding.FragmentFindBinding
import com.enov.base.mvvm.fragment.vm.FindFragVM

class FindFrag: BaseFragment<FindFragVM, FragmentFindBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_find
    }

    override fun initView() {
        binding.vm = viewModel
    }
}