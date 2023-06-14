package com.enov.base.mvvm.view.act

import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.enov.base.R
import com.enov.base.core.base.BaseActivity
import com.enov.base.databinding.ActivityMainBinding
import com.enov.base.mvvm.vm.MainActVM

class MainActivity: BaseActivity<MainActVM, ActivityMainBinding>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        binding.vm = viewModel
        val navHostFragment: NavHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        binding.bottomNavigationView.setupWithNavController(navHostFragment.findNavController())
    }
}