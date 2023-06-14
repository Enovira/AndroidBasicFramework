package com.enov.base

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner
import com.enov.base.core.base.EventViewModel
import java.lang.ref.WeakReference

class App : Application(), ViewModelStoreOwner {

    companion object {
        lateinit var instance: App
        private lateinit var context: WeakReference<Context>
        lateinit var eventViewModel: EventViewModel
        fun getContext(): Context {
            return context.get()!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        context = WeakReference(applicationContext)
        eventViewModel = getViewModelProvider()[EventViewModel::class.java]
    }

    private fun getViewModelProvider(): ViewModelProvider {
        return ViewModelProvider(this, getFactory())
    }

    private fun getFactory(): ViewModelProvider.Factory {
        return ViewModelProvider.AndroidViewModelFactory(this)
    }

    override val viewModelStore: ViewModelStore by lazy {
        ViewModelStore()
    }

}