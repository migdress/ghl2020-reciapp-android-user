package com.reciapp.user.data.repositories

import com.reciapp.user.R
import com.reciapp.user.data.models.recycleType.RecycleType
import com.reciapp.user.domain.repositories.RecycleTypeRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class RecycleTypeRepositoryImpl: RecycleTypeRepository {

    /**
     * Return the recycle types list available in the app
     */
    override fun getRecycleTypes(): List<RecycleType> {
        val recycleTypesList = arrayListOf<RecycleType>()

        with(recycleTypesList){
            add(RecycleType(R.drawable.ic_paperboard, R.string.general_paperboard))
            add(RecycleType(R.drawable.ic_plastic, R.string.general_plastic))
            add(RecycleType(R.drawable.ic_glass, R.string.general_glass))
            add(RecycleType(R.drawable.ic_glass, R.string.general_technology))
            add(RecycleType(R.drawable.ic_glass, R.string.general_metal))
        }

        return recycleTypesList
    }
}
