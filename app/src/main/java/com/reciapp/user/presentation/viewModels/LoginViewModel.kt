package com.reciapp.user.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.reciapp.user.domain.useCases.LoginUC
import com.reciapp.user.presentation.states.LoginState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Jorge Henao on 30/05/20.
 */
class LoginViewModel(
    private val loginUC: LoginUC,
    private val loginLiveData: MutableLiveData<LoginState>
) : BaseViewModel() {

    val getLoginLiveData: LiveData<LoginState>
        get() = loginLiveData

    /**
     * Method used to control the login request with the view
     */
    fun login(userName: String, password: String){
        addDisposable(loginUC.login(userName, password)
            .doOnSubscribe {
                loginLiveData.postValue(LoginState.Loading)
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                loginLiveData.value = LoginState.Success
            },{
                loginLiveData.value = LoginState.Failure
            }))
    }
}
