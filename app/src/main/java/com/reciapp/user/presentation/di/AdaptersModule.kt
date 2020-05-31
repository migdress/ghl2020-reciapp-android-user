package com.reciapp.user.presentation.di

import com.reciapp.user.presentation.adapters.RecycleTypeAdapter
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 31/05/20.
 */

val adaptersModule: Module = module {
    factory {
        RecycleTypeAdapter()
    }
}
