package com.example.domain.usecase

import com.example.domain.model.EmployeeModel
import com.example.domain.param.EmployeeParams
import com.example.domain.repository.EmployeeRepository
import kotlin.coroutines.CoroutineContext
import com.example.core.Result
import com.example.core.Error

class EmployeeUseCaseImpl(private val repository: EmployeeRepository) : EmployeeUseCase {
    override suspend fun execute(
        params: EmployeeParams, coroutineContext: CoroutineContext
    ): Result<Error, EmployeeModel> =
        repository.getEmployee(
            params.results
        )
}