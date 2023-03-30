package com.example.domain.di

import com.example.domain.usecase.EmployeeUseCase
import com.example.domain.usecase.EmployeeUseCaseImpl
import org.koin.dsl.module

val useCaseModule = module {
    factory<EmployeeUseCase> { EmployeeUseCaseImpl(repository = get()) }
}