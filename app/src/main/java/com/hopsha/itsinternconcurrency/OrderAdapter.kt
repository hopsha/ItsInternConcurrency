package com.hopsha.itsinternconcurrency

import android.annotation.SuppressLint
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.view.setPadding
import androidx.recyclerview.widget.RecyclerView
import com.hopsha.itsinternconcurrency.Status.*

class OrderAdapter(
    private val entries: List<Order>
) : RecyclerView.Adapter<OrderAdapter.ViewHolder>() {

    class ViewHolder(
        private val view: TextView
    ) : RecyclerView.ViewHolder(view) {

        @SuppressLint("SetTextI18n")
        fun bind(order: Order) {
            val status = when(order.status) {
                DONE -> ""
                IN_PROGRESS -> "In progress..."
                QUEUED -> "Queued..."
            }
            view.text = "${order.name}\n$status"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val textView = TextView(parent.context).apply {
            setPadding(20)
        }
        return ViewHolder(textView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val entry = entries[position]
        holder.bind(entry)
    }

    override fun getItemCount(): Int {
        return entries.size
    }
}