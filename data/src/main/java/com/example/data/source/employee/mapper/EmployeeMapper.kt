package com.example.data.source.employee.mapper

import com.example.data.entity.EmployeeEntity
import com.example.domain.model.EmployeeModel

interface EmployeeMapper {
    fun toEmployee(entity: EmployeeEntity): EmployeeModel
}