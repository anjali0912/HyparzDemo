package com.example.hyparzdemo.feature.employee

import androidx.lifecycle.MutableLiveData
import com.example.core.BaseData
import com.example.domain.model.EmployeeItem

data class EmployeeData(
    val employeeList: MutableLiveData<List<EmployeeItem>> = MutableLiveData(emptyList()),
) : BaseData() {

    internal var pageId: Int = 0
    internal var totalPages: Int = 10

    fun setEmployeeList(employeeList: List<EmployeeItem>) {
        this.employeeList.postValue(employeeList)
    }
}