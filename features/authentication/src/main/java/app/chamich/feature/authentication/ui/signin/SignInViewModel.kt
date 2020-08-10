/*
 * Copyright (c) 2020 Chamich Apps. All rights reserved.
 */

package app.chamich.feature.authentication.ui.signin

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.chamich.feature.authentication.model.Resource
import app.chamich.library.authentication.IAuthenticator
import app.chamich.library.authentication.IUser
import app.chamich.library.authentication.exceptions.AuthenticatorException
import app.chamich.library.logger.ILogger
import kotlinx.coroutines.launch

internal class SignInViewModel @ViewModelInject constructor(
    private val authenticator: IAuthenticator,
    private val logger: ILogger
) : ViewModel() {

    private var user = MutableLiveData<Resource<IUser>>()

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //region Public Functions

    fun signIn(email: String, password: String) {
        logger.debug(message = "Sign In (email: ${email}, password: ${password})")
        viewModelScope.launch {
            user.postValue(Resource.loading(null))
            try {
                user.postValue(Resource.success(authenticator.signIn(email, password)))
            } catch (exception: AuthenticatorException.SignInException) {
                logger.error(message = "Exception while Sign In", throwable = exception)
                user.postValue(Resource.error(exception))
            }
        }
    }

    fun getSignedInUser(): LiveData<Resource<IUser>> = user

    fun resetSignedInUser() {
        user = MutableLiveData()
    }

    //endregion
}
