package com.example.hyparzdemo.feature.employeedetails

import android.app.Application
import android.util.Log
import com.example.core.BaseViewModel
import com.example.domain.model.EmployeeItem

class EmployeeDetailsViewModel(
    application: Application,
    data: EmployeeDetailsData
) : BaseViewModel<EmployeeDetailsData, EmployeeDetailsEvents>(application, data) {

    fun setEmployeeInfo(employee: EmployeeItem?) {
        data.setEmployeeItem(employee)
    }
}