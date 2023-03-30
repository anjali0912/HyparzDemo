package com.example.data.di

import com.example.core.REST_CLIENT_MODULE
import com.example.data.repository.EmployeeRepositoryImpl
import com.example.data.source.employee.EmployeeRemoteSource
import com.example.data.source.employee.EmployeeRemoteSourceImpl
import com.example.data.source.employee.api.GetEmployeeApi
import com.example.data.source.employee.mapper.EmployeeMapper
import com.example.data.source.employee.mapper.EmployeeMapperImpl
import com.example.domain.repository.EmployeeRepository
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit

val apiModule = module {
    single<GetEmployeeApi> { get<Retrofit>(named(REST_CLIENT_MODULE)).create(GetEmployeeApi::class.java) }

}

val repositoryModule = module {
    single<EmployeeRepository> { EmployeeRepositoryImpl(source = get()) }
}

val sourceModule = module {
    single<EmployeeRemoteSource> {
        EmployeeRemoteSourceImpl(
            getEmployeeApi = get(),
            mapper = get()
        )
    }
}

val mapperModule = module {
    single<EmployeeMapper> { EmployeeMapperImpl() }
}