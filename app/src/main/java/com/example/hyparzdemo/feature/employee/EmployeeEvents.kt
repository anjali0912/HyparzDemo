package com.example.hyparzdemo.feature.employee

import com.example.core.BaseEvent
import com.example.domain.model.EmployeeItem

sealed class EmployeeEvents : BaseEvent {
    data class OnEmployeeItemClick(val employeeItem: EmployeeItem) : EmployeeEvents()
}