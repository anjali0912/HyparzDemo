package com.example.core

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import kotlin.reflect.KClass

abstract class BaseActivity<B : ViewDataBinding, E : BaseEvent, D : BaseData, out VM : BaseViewModel<D, E>>(
    viewModelClazz: KClass<VM>,
    @LayoutRes private val layoutId: Int
) : AppCompatActivity(), EventListener {

    protected val viewModel: VM by viewModel(clazz = viewModelClazz)
    protected lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.apply {
            lifecycleOwner = this@BaseActivity
            setVariable(BR.viewModel, this@BaseActivity.viewModel)
        }
        viewModel.bindData(binding)
        viewModel.liveEvents.observeForever {
            eventUpdated(it)
        }
        getInitialData()
    }

    open fun getInitialData() {}

    abstract override fun eventUpdated(event: BaseEvent)
}