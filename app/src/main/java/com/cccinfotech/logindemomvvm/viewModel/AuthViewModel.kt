package com.cccinfotech.logindemomvvm.viewModel

import android.text.TextUtils
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cccinfotech.logindemomvvm.model.LoginRequest
import com.cccinfotech.logindemomvvm.model.LoginResponse
import com.cccinfotech.logindemomvvm.repository.UserRepository
import com.cccinfotech.logindemomvvm.utils.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val userRepository: UserRepository) : ViewModel(){

    val userResponseLiveData : LiveData<NetworkResult<LoginResponse>>
        get() = userRepository.userResponseLivaData


    fun loginUser(userRequest: LoginRequest){
        viewModelScope.launch {
            userRepository.loginUser(userRequest)
        }
    }
    fun mobileValidation(mobile:String):Pair<Boolean,String>{
        var result = Pair(true,"")

        if (TextUtils.isEmpty(mobile) ){
            result = Pair(false,"please enter mobile")
        }
        return result

    }

    fun validateCredentials(mobile:String, password:String): Pair<Boolean,String>{

        var result = Pair(true,"")
        if (TextUtils.isEmpty(mobile) || TextUtils.isEmpty(password)){
            result = Pair(false,"please provide the credential")
        }
        /*else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
        {
            result = Pair(false,"please provide valid email")
        }*/
        else if (password.length <= 3){
            result = Pair(false,"Password length should be greater than 3")
        }
        /*else {
            // Handle other cases where password might be incorrect
            result = Pair(false,"Incorrect password")
        }*/

        return result
    }




}