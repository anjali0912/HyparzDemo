package com.example.domain.repository

import com.example.domain.model.EmployeeModel

import com.example.core.Result
import com.example.core.Error

interface EmployeeRepository {
    suspend fun getEmployee(
        results: Int
    ): Result<Error, EmployeeModel>
}