package com.example.hyparzdemo.feature.employee

import android.app.Application
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.core.BaseViewModel
import com.example.domain.model.EmployeeItem
import com.example.domain.param.EmployeeParams
import com.example.domain.usecase.EmployeeUseCase
import com.example.hyparzdemo.R
import kotlinx.coroutines.launch

class EmployeeViewModel(
    application: Application,
    data: EmployeeData,
    private val employeeUseCase: EmployeeUseCase
) : BaseViewModel<EmployeeData, EmployeeEvents>(application, data) {

    init {
        getEmployee()
    }

    private fun getEmployee() {
        viewModelScope.launch {
            employeeUseCase.execute(
                getEmployeeParams()
            ).mapResult(
                success = { employeeModel ->
                    val list = addEmployeeItems(employeeModel.employeeItem)
                    data.setEmployeeList(list)
                },
                failure = {
                })
        }
    }

    private fun getEmployeeParams(): EmployeeParams {
        data.pageId = data.pageId + PAGE_COUNT
        return EmployeeParams(
            results = data.pageId
        )
    }

    fun getEmployeeData() {
        if (data.pageId != data.totalPages) {
            getEmployee()
        }
    }

    private fun addEmployeeItems(list: List<EmployeeItem>): ArrayList<EmployeeItem> {
        val newList = arrayListOf<EmployeeItem>()
        data.employeeList.value?.let { newList.addAll(it) }
        newList.addAll(list)
        return newList
    }

    val onItemClickListener: (model: Any, viewId: Int, clickedPosition: Int) -> Unit =
        { model, viewId, clickedPosition ->
            when (viewId) {
                R.id.cardView -> {
                    model as EmployeeItem
                    updateEvent(EmployeeEvents.OnEmployeeItemClick(model))
                }
            }
        }

    companion object {
        const val PAGE_COUNT = 5
    }
}