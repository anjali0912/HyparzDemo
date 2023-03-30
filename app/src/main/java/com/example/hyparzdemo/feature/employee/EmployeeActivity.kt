package com.example.hyparzdemo.feature.employee

import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.core.BaseActivity
import com.example.core.BaseEvent
import com.example.hyparzdemo.R
import com.example.hyparzdemo.databinding.ActivityEmployeeBinding
import com.example.hyparzdemo.feature.employeedetails.EmployeeDetailsActivity
import com.example.hyparzdemo.feature.list.EmployeeItemDecoration
import com.example.hyparzdemo.feature.list.EmployeeListAdapter

class EmployeeActivity :
    BaseActivity<ActivityEmployeeBinding, EmployeeEvents, EmployeeData, EmployeeViewModel>(
        EmployeeViewModel::class,
        R.layout.activity_employee
    ) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding?.rvEmployee?.addItemDecoration(
            EmployeeItemDecoration(
                resources.getDimension(R.dimen.margin_card_view).toInt()
            )
        )
        binding?.rvEmployee?.adapter = EmployeeListAdapter()

        binding?.rvEmployee?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)) {
                    viewModel.getEmployeeData()
                }
            }
        })
    }

    override fun eventUpdated(event: BaseEvent) {
        when (event) {
            is EmployeeEvents.OnEmployeeItemClick -> {
                val intent = Intent(this, EmployeeDetailsActivity::class.java)
                intent.putExtra(EXTRA_EMPLOYEE_INFO, event.employeeItem)
                startActivity(intent)
            }
        }
    }

    companion object {
        private const val EXTRA_EMPLOYEE_INFO = "employee_info"
    }
}