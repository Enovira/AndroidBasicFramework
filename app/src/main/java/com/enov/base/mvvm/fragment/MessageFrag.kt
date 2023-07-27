package com.enov.base.mvvm.fragment

import com.enov.base.R
import com.enov.base.core.base.BaseFragment
import com.enov.base.databinding.FragmentMessageBinding
import com.enov.base.mvvm.fragment.vm.MessageFragVM

class MessageFrag: BaseFragment<MessageFragVM, FragmentMessageBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_message
    }

    override fun initView() {
        binding.vm = viewModel
    }
}