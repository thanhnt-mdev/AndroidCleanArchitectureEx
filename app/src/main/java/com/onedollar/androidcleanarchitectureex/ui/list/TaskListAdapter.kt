package com.onedollar.androidcleanarchitectureex.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.onedollar.androidcleanarchitectureex.R
import com.onedollar.androidcleanarchitectureex.model.TaskUIModel
import kotlinx.android.synthetic.main.task_item_view.view.*

class TaskListAdapter : ListAdapter<TaskUIModel, TaskListAdapter.ViewHolder>(ItemCallback()) {

    var listener: Listener? = null

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.task_item_view, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.itemView.tvName.text = item.title
        holder.itemView.setOnClickListener { listener?.onItemClick(position, item) }
    }

    interface Listener {
        fun onItemClick(position: Int, item: TaskUIModel)
    }
}

class ItemCallback : DiffUtil.ItemCallback<TaskUIModel>() {
    override fun areItemsTheSame(oldItem: TaskUIModel, newItem: TaskUIModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: TaskUIModel, newItem: TaskUIModel): Boolean {
        return oldItem == newItem
    }

}