package com.example.hyparzdemo.feature.list

import androidx.recyclerview.widget.DiffUtil
import com.example.domain.model.EmployeeItem

class EmployeeListDiffCallback : DiffUtil.ItemCallback<EmployeeItem>() {
    override fun areItemsTheSame(
        oldItem: EmployeeItem,
        newItem: EmployeeItem
    ): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: EmployeeItem,
        newItem: EmployeeItem
    ): Boolean =
        oldItem == newItem
}