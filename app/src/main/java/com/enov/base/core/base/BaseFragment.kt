package com.enov.base.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

abstract class BaseFragment<VM : ViewModel, DB : ViewDataBinding> : Fragment() {

    lateinit var binding: DB
    lateinit var viewModel: VM

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        viewModel = createViewModel()
        initView()
        return binding.root
    }

    abstract fun initView()

    @LayoutRes
    abstract fun getLayoutId(): Int

    private fun createViewModel(): VM {
        return ViewModelProvider(this)[getJvmClazz(this)]
    }

    @Suppress("UNCHECKED_CAST")
    private fun <VM> getJvmClazz(obj: Any): VM {
        return (obj.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
    }

}