package com.example.domain.usecase

import com.example.core.BaseUseCase
import com.example.domain.model.EmployeeModel
import com.example.domain.param.EmployeeParams

interface EmployeeUseCase :
    BaseUseCase<EmployeeParams, EmployeeModel> {
}