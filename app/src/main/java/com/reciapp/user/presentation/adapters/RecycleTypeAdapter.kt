package com.reciapp.user.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.reciapp.user.R
import com.reciapp.user.data.models.recycleType.RecycleType
import kotlinx.android.synthetic.main.item_recycler_types.view.*

/**
 * Created by Jorge Henao on 31/05/20.
 */
class RecycleTypeAdapter :
    RecyclerView.Adapter<RecycleTypeAdapter.RecycleTypeViewHolder>() {

    private val types: MutableList<RecycleType> = mutableListOf()

    fun setData(data: List<RecycleType>) {
        types.clear()
        types.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecycleTypeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_types, parent, false)
    )

    override fun getItemCount() = types.size

    override fun onBindViewHolder(viewHolder: RecycleTypeViewHolder, position: Int) {
        val type = types[position]

        with(viewHolder.view) {
            txvRecycleDescription.text = context.resources.getString(type.description)
            imvRecycleIcon.setImageResource(type.icon)
        }
    }

    class RecycleTypeViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
