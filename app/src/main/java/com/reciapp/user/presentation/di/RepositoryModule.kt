package com.reciapp.user.presentation.di

import com.reciapp.user.data.repositories.UserRepositoryImpl
import com.reciapp.user.data.repositories.LoginRemoteRepositoryImpl
import com.reciapp.user.data.repositories.RecycleTypeRepositoryImpl
import com.reciapp.user.domain.repositories.UserRepository
import com.reciapp.user.domain.repositories.LoginRemoteRepository
import com.reciapp.user.domain.repositories.RecycleTypeRepository
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

    factory<UserRepository> {
        UserRepositoryImpl(
            userPreferences = get()
        )
    }

    factory<RecycleTypeRepository> {
        RecycleTypeRepositoryImpl()
    }
}
