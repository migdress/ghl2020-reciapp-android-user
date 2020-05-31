package com.reciapp.user.presentation.di

import com.reciapp.user.R
import com.reciapp.user.data.networkeEndPoints.LoginApi
import com.reciapp.user.utils.network.ManagerNetwork
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val apiModule: Module = module {

    factory {
        ManagerNetwork().getRetrofitInstance(
            androidContext().resources.getString(R.string.login_base_url)
        ).create(LoginApi::class.java)
    }
}
