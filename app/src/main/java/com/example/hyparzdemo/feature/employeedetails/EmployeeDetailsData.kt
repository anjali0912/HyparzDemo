package com.example.hyparzdemo.feature.employeedetails

import androidx.lifecycle.MutableLiveData
import com.example.core.BaseData
import com.example.domain.model.EmployeeItem

data class EmployeeDetailsData(
    val employeeItem: MutableLiveData<EmployeeItem> = MutableLiveData(),
    val employeeName: MutableLiveData<String> = MutableLiveData("")
) : BaseData() {

    fun setEmployeeItem(employee: EmployeeItem?) {
        this.employeeItem.postValue(employee)
        setEmployeeName(employee)
    }

    private fun setEmployeeName(employee: EmployeeItem?) {
        this.employeeName.postValue("${employee?.titleName} ${employee?.firstName} ${employee?.lastName}")
    }
}