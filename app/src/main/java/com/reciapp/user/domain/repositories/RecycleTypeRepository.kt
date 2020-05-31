package com.reciapp.user.domain.repositories

import com.reciapp.user.data.models.recycleType.RecycleType

/**
 * Created by Jorge Henao on 31/05/20.
 */
interface RecycleTypeRepository {

    /**
     * Return the recycle types list available in the app
     */
    fun getRecycleTypes(): List<RecycleType>
}
