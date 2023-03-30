package com.example.data.source.employee

import com.example.data.source.employee.api.GetEmployeeApi
import com.example.data.source.employee.mapper.EmployeeMapper
import com.example.domain.model.EmployeeModel
import com.example.core.Result
import com.example.core.Error

class EmployeeRemoteSourceImpl(
    private val getEmployeeApi: GetEmployeeApi,
    val mapper: EmployeeMapper
) : EmployeeRemoteSource {

    override suspend fun getEmployee(
        results: Int
    ): Result<Error, EmployeeModel> =
        execute(
            service = {
                getEmployeeApi.getEmployee(results = results)
            },
            success = { employeeEntity, _ -> mapper.toEmployee(employeeEntity) },
            failure = { Error.RemoteError() }
        )
}