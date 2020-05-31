package com.reciapp.user.data.repositories

import com.reciapp.user.R
import com.reciapp.user.data.models.recycleType.RecycleType
import com.reciapp.user.domain.repositories.RecycleTypeRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class RecycleTypeRepositoryImpl : RecycleTypeRepository {

    /**
     * Return the recycle types list available in the app
     */
    override fun getRecycleTypes(): List<RecycleType> {
        val recycleTypesList = arrayListOf<RecycleType>()

        with(recycleTypesList) {
            add(RecycleType(R.drawable.ic_paperboard, R.string.general_paperboard, false, PAPER))
            add(RecycleType(R.drawable.ic_plastic, R.string.general_plastic, false, PLASTIC))
            add(RecycleType(R.drawable.ic_glass, R.string.general_glass, false, GLASS))
            add(RecycleType(R.drawable.ic_technology, R.string.general_technology, false, METAL))
            add(RecycleType(R.drawable.ic_metal, R.string.general_metal, false, TECHNOLOGY))
        }

        return recycleTypesList
    }

    companion object{
        const val PAPER = "paper"
        const val PLASTIC = "plastic"
        const val GLASS = "glass"
        const val METAL = "metal"
        const val TECHNOLOGY = "technology"
    }
}
