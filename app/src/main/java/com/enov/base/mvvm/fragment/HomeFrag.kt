package com.enov.base.mvvm.fragment

import android.content.Intent
import com.enov.base.R
import com.enov.base.core.base.BaseFragment
import com.enov.base.databinding.FragmentHomeBinding
import com.enov.base.mvvm.activity.SubActivity
import com.enov.base.mvvm.fragment.vm.HomeFragVM

class HomeFrag: BaseFragment<HomeFragVM, FragmentHomeBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun initView() {
        binding.vm = viewModel
        binding.toBleAct.setOnClickListener {
            startActivity(Intent(requireContext(), SubActivity::class.java))
        }
    }
}