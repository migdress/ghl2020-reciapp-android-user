package com.reciapp.user.presentation.di

import com.reciapp.user.data.preferences.ShiftPreferences
import com.reciapp.user.data.preferences.UserPreferences
import com.reciapp.user.utils.preferences.NamesPreferences
import com.reciapp.user.utils.preferences.PreferencesHelper
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by Jorge Henao on 30/05/20.
 */
val preferencesModule: Module = module {
    single {
        UserPreferences(
            PreferencesHelper.customPrefs(
                androidContext(),
                NamesPreferences.USER
            )
        )
    }
    factory {
        ShiftPreferences(
            PreferencesHelper.customPrefs(
                androidContext(),
                NamesPreferences.SHIFT
            )
        )
    }
}
