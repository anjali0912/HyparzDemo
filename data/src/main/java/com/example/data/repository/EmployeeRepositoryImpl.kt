package com.example.data.repository

import com.example.data.source.employee.EmployeeRemoteSource
import com.example.domain.repository.EmployeeRepository
import com.example.core.Result
import com.example.core.Error
import com.example.domain.model.EmployeeModel

class EmployeeRepositoryImpl(private val source: EmployeeRemoteSource) :
    EmployeeRepository {

    override suspend fun getEmployee(
        results: Int
    ): Result<Error, EmployeeModel> =
        source.getEmployee(results)
}