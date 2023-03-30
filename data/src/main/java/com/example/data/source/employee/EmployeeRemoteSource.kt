package com.example.data.source.employee

import com.example.core.ResponseMapper
import com.example.domain.model.EmployeeModel
import com.example.core.Result
import com.example.core.Error

interface EmployeeRemoteSource : ResponseMapper {
    suspend fun getEmployee(
        results: Int
    ): Result<Error, EmployeeModel>
}