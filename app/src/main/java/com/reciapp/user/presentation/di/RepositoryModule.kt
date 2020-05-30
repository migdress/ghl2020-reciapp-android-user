package com.reciapp.user.presentation.di

import com.reciapp.user.data.repositories.LoginCloudRepositoryImpl
import com.reciapp.user.domain.repositories.LoginCloudRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val repositoryModule: Module = module {
    factory<LoginCloudRepository> {
        LoginCloudRepositoryImpl(
            loginApi = get()
        )
    }
}
