package com.enov.base.mvvm.fragment

import com.enov.base.R
import com.enov.base.core.base.BaseFragment
import com.enov.base.core.base.TitleBar
import com.enov.base.databinding.FragmentBluetoothOperationBinding
import com.enov.base.mvvm.fragment.vm.BluetoothOperationFragVM

class BluetoothOperationFrag: BaseFragment<BluetoothOperationFragVM, FragmentBluetoothOperationBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_bluetooth_operation
    }

    override fun initView() {
        binding.titleBar.setDelegate(object : TitleBar.Delegate {
            override fun onClickLeft() {
                activity?.finish()
            }

            override fun onClickRight() {
            }
        })
    }
}