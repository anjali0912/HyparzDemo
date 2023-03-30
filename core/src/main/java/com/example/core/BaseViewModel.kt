package com.example.core

import android.app.Application
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.AndroidViewModel

abstract class BaseViewModel<D : BaseData, E : BaseEvent>(
    application: Application,
    protected val data: D
) : AndroidViewModel(application) {

    val liveEvents: SingleLiveEvent<E> = SingleLiveEvent()

    protected fun getStringById(resId: Int) = this.getApplication<Application>().resources.getString(resId)
    protected fun getStringByIdAndMessage(resId: Int, message: String) = this.getApplication<Application>().resources.getString(resId, message)
    protected fun getArrayById(resId: Int): Array<String> = this.getApplication<Application>().resources.getStringArray(resId)

    internal fun bindData(binding: ViewDataBinding) {
        binding.setVariable(BR.data, data)
    }

    infix fun updateEvent(event: E?) {
        event?.let { liveEvents.postValue(event) }
    }
}