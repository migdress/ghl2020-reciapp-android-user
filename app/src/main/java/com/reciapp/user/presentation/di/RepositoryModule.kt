package com.reciapp.user.presentation.di

import com.reciapp.user.data.repositories.LoginLocalRepositoryImpl
import com.reciapp.user.data.repositories.LoginRemoteRepositoryImpl
import com.reciapp.user.domain.repositories.LoginLocalRepository
import com.reciapp.user.domain.repositories.LoginRemoteRepository
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val repositoryModule: Module = module {

    factory<LoginRemoteRepository> {
        LoginRemoteRepositoryImpl(
            loginApi = get()
        )
    }

    factory<LoginLocalRepository> {
        LoginLocalRepositoryImpl(
            userPreferences = get()
        )
    }
}
