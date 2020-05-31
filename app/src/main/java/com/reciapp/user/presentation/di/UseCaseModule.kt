package com.reciapp.user.presentation.di

import com.reciapp.user.domain.useCases.LoginUC
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val useCasesModule: Module = module {
    factory {
        LoginUC(
            loginCloudRepository = get()
        )
    }
}
