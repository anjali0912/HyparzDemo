package com.example.hyparzdemo.feature.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.core.BaseListAdapter
import com.example.core.BaseViewHolder
import com.example.domain.model.EmployeeItem
import com.example.hyparzdemo.databinding.LayoutEmployeeItemBinding

class EmployeeListAdapter :
    BaseListAdapter<EmployeeItem, EmployeeListAdapter.EmployeeListViewHolder>(
        EmployeeListDiffCallback()
    ) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeeListViewHolder {
        val employeeItemBinding = LayoutEmployeeItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return EmployeeListViewHolder(
            binding = employeeItemBinding,
            itemClickListener = this.listItemClickListener,
            arrayViewClickable = arrayOf(
                employeeItemBinding.cardView
            )
        )
    }

    class EmployeeListViewHolder(
        binding: LayoutEmployeeItemBinding,
        itemClickListener: (EmployeeItem, Int, Int) -> Unit,
        arrayViewClickable: Array<View>
    ) : BaseViewHolder<EmployeeItem>(binding, itemClickListener, arrayViewClickable)
}