package com.example.hyparzdemo.di

import com.example.hyparzdemo.feature.employee.EmployeeData
import com.example.hyparzdemo.feature.employee.EmployeeViewModel
import com.example.hyparzdemo.feature.employeedetails.EmployeeDetailsData
import com.example.hyparzdemo.feature.employeedetails.EmployeeDetailsViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {

    viewModel {
        EmployeeViewModel(
            application = androidApplication(),
            data = EmployeeData(),
            employeeUseCase = get()
        )
    }

    viewModel {
        EmployeeDetailsViewModel(
            application = androidApplication(),
            data = EmployeeDetailsData()
        )
    }
}