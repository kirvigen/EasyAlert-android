package com.kirvigen.easyalertlibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*
import kotlinx.android.synthetic.main.item_list.view.*

class AdapterList(var data:Array<String>,val onClick:(Int)->Unit): RecyclerView.Adapter<AdapterList.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
        holder.TextItem.setOnClickListener { onClick(position) }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),LayoutContainer {
        fun bind(t: String) {
               TextItem.text = t
        }
    }
}