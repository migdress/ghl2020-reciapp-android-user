package com.reciapp.user.presentation.di

import com.reciapp.user.domain.repositories.UserRepository
import com.reciapp.user.domain.useCases.LoginUC
import com.reciapp.user.domain.useCases.ScoreUC
import com.reciapp.user.domain.useCases.RecycleTypeUC
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val useCasesModule: Module = module {
    factory {
        LoginUC(
            loginCloudRepository = get(),
            userRepository = get()
        )
    }
    factory {
        ScoreUC(
            scoreRemoteRepository = get(),
            getUserId = get<UserRepository>()::getUserId
        )
    }
    factory {
        RecycleTypeUC(
            recycleTypeRepository = get()
        )
    }
}
