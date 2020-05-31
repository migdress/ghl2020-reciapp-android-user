package com.reciapp.user.domain.useCases

import com.reciapp.user.domain.repositories.RecycleTypeRepository

/**
 * Created by Jorge Henao on 31/05/20.
 */
class RecycleTypeUC(
    private val recycleTypeRepository: RecycleTypeRepository
) {

    fun getRecycleTypes() = recycleTypeRepository.getRecycleTypes()
}
