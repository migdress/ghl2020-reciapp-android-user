package com.reciapp.user.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.reciapp.user.R
import com.reciapp.user.data.models.recycleType.RecycleType
import com.reciapp.user.utils.viewExtensions.hide
import com.reciapp.user.utils.viewExtensions.visible
import kotlinx.android.synthetic.main.item_recycler_types.view.*

/**
 * Created by Jorge Henao on 31/05/20.
 */
class RecycleTypeAdapter :
    RecyclerView.Adapter<RecycleTypeAdapter.RecycleTypeViewHolder>() {

    private val types: MutableList<RecycleType> = mutableListOf()

    fun setTypes(data: List<RecycleType>) {
        types.clear()
        types.addAll(data)
        notifyDataSetChanged()
    }

    fun getTypes() = types

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = RecycleTypeViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_types, parent, false)
    )

    override fun getItemCount() = types.size

    override fun onBindViewHolder(viewHolder: RecycleTypeViewHolder, position: Int) {
        val type = types[position]

        bindItem(position, viewHolder)

        viewHolder.view.setOnClickListener {
            type.isSelected = !type.isSelected

            //Se cambian los valores del nuevo item seleccionado y se refresca la lista y el recycler
            types[position] = type

            //Se le informa al recycle que el item cambio
            notifyItemChanged(position)
        }
    }

    private fun bindItem(position: Int, viewHolder: RecycleTypeViewHolder){
        val type = types[position]

        with(viewHolder.view) {
            txvRecycleDescription.text = context.resources.getString(type.description)
            imvRecycleIcon.setImageResource(type.icon)

            if (type.isSelected) {
                cvItemRecycleType.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.colorPrimaryLight)
                )
                imvChecked.visible()
            } else {
                cvItemRecycleType.setCardBackgroundColor(
                    ContextCompat.getColor(context, R.color.white)
                )
                imvChecked.hide()
            }
        }
    }

    class RecycleTypeViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}
