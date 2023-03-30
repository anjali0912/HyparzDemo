package com.example.core

import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class BindingAdapters {
    companion object {

        @JvmStatic
        @BindingAdapter("submitListItems")
        fun submitListItems(recyclerView: RecyclerView?, list: List<Any>) {
            recyclerView?.adapter?.let {
                (it as ListAdapter<Any, *>).submitList(list)
            }
        }

        @JvmStatic
        @BindingAdapter("onButtonClickListener")
        fun setOnButtonClick(
            button: Button,
            onClickListener: () -> Unit
        ) {
            button.setOnClickListener {
                onClickListener.invoke()
            }
        }

        @JvmStatic
        @BindingAdapter("onClickListItemListener")
        fun setOnItemClickListener(
            recyclerView: RecyclerView,
            onListItemClickListener: (model: Any, viewId: Int, clickedPosition: Int) -> Unit
        ) {
            (recyclerView.adapter as BaseListAdapter<Any, *>).setOnListItemClickListener(
                onListItemClickListener
            )
        }

        @JvmStatic
        @BindingAdapter("employeeImage")
        fun loadEmployeeImage(view: ImageView, imageUrl: String?) {
            Glide.with(view.context)
                .load(imageUrl)
                .into(view)
        }
    }
}