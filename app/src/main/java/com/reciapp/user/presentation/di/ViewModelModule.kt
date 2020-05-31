package com.reciapp.user.presentation.di

import androidx.lifecycle.MutableLiveData
import com.reciapp.user.presentation.viewModels.LoginViewModel
import com.reciapp.user.presentation.viewModels.RecycleTypeViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val viewModelModule: Module = module {
    viewModel {
        LoginViewModel(
            loginUC = get(),
            loginLiveData = MutableLiveData()
        )
    }
    viewModel {
        RecycleTypeViewModel(
            recycleTypeUC = get(),
            recycleTypeLiveData = MutableLiveData()
        )
    }
}
