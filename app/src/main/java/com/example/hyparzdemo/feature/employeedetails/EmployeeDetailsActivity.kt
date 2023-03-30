package com.example.hyparzdemo.feature.employeedetails

import android.os.Bundle
import com.example.core.BaseActivity
import com.example.core.BaseEvent
import com.example.domain.model.EmployeeItem
import com.example.hyparzdemo.R
import com.example.hyparzdemo.databinding.ActivityEmployeeDetailsBinding

class EmployeeDetailsActivity :
    BaseActivity<ActivityEmployeeDetailsBinding, EmployeeDetailsEvents, EmployeeDetailsData, EmployeeDetailsViewModel>(
        EmployeeDetailsViewModel::class,
        R.layout.activity_employee_details
    ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        intent.apply {
            if (this.hasExtra(EXTRA_EMPLOYEE_INFO)) {
                val employeeInfo =
                    this.extras?.getParcelable<EmployeeItem>(EXTRA_EMPLOYEE_INFO)
                viewModel.setEmployeeInfo(employeeInfo)
            }
        }
    }

    override fun eventUpdated(event: BaseEvent) {
    }

    companion object {
        private const val EXTRA_EMPLOYEE_INFO = "employee_info"
    }
}