package com.example.data.source.employee.api

import com.example.data.entity.EmployeeEntity
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface GetEmployeeApi {

    @GET("api")
    @Headers("Content-Type: application/json;charset=UTF-8", "Accept: application/json")
    suspend fun getEmployee(
        @Query("results") results: Int
    ): Response<EmployeeEntity>
}