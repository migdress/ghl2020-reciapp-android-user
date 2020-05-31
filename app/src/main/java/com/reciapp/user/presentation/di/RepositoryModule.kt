package com.reciapp.user.presentation.di

import com.reciapp.user.data.repositories.LoginRemoteRepositoryImpl
import com.reciapp.user.data.repositories.OpenShiftRemoteRepositoryImpl
import com.reciapp.user.data.repositories.RecycleTypeRepositoryImpl
import com.reciapp.user.data.repositories.ScoreRemoteRepositoryImpl
import com.reciapp.user.data.repositories.ShiftRemoteRepositoryImpl
import com.reciapp.user.data.repositories.ShiftRepositoryImpl
import com.reciapp.user.data.repositories.UserRepositoryImpl
import com.reciapp.user.domain.repositories.LoginRemoteRepository
import com.reciapp.user.domain.repositories.OpenShiftRemoteRepository
import com.reciapp.user.domain.repositories.RecycleTypeRepository
import com.reciapp.user.domain.repositories.ScoreRemoteRepository
import com.reciapp.user.domain.repositories.ShiftRemoteRepository
import com.reciapp.user.domain.repositories.ShiftRepository
import com.reciapp.user.domain.repositories.UserRepository
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

    factory<ScoreRemoteRepository> {
        ScoreRemoteRepositoryImpl(
            scoreApi = get()
        )
    }

    factory<OpenShiftRemoteRepository> {
        OpenShiftRemoteRepositoryImpl(
            openShiftsApi = get()
        )
    }

    factory<ShiftRepository> {
        ShiftRepositoryImpl(
            shiftPreferences = get()
        )
    }

    factory<ShiftRemoteRepository> {
        ShiftRemoteRepositoryImpl(
            shiftApi = get()
        )
    }
}
