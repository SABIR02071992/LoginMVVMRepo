package com.cccinfotech.logindemomvvm.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.cccinfotech.logindemomvvm.api.UserApi
import com.cccinfotech.logindemomvvm.model.LoginRequest
import com.cccinfotech.logindemomvvm.model.LoginResponse
import com.cccinfotech.logindemomvvm.utils.Constant.TAG
import com.cccinfotech.logindemomvvm.utils.NetworkResult
import org.json.JSONObject
import javax.inject.Inject

class UserRepository @Inject constructor(private val userApi: UserApi) {

    private val _userResponseMutableLivaData = MutableLiveData<NetworkResult<LoginResponse>>()
    val userResponseLivaData : LiveData<NetworkResult<LoginResponse>>
        get() = _userResponseMutableLivaData


    /*..login user..*/
    suspend fun loginUser(userRequest: LoginRequest){

       // _userResponseMutableLivaData.postValue(NetworkResult.Loading())

        try {
            val response = userApi.loginUser(userRequest)


             if (response.isSuccessful && response.body()?.ResponseCode=="200"){
                 _userResponseMutableLivaData.postValue(NetworkResult.Success(response.body()!!))

                 Log.d(TAG,response.body()!!.ResponseMessage.toString())

             }
              else if (response.isSuccessful && response.body()?.error_code=="308"){
                 Log.d(TAG,response.body()!!.ResponseMessage.toString())

                // _userResponseMutableLivaData.postValue(NetworkResult.Error(response.body()!!.ResponseMessage))



             }
            else if (response.isSuccessful && response.body()?.error_code=="206"){
                 Log.d(TAG,response.body()!!.ResponseMessage.toString())
                 _userResponseMutableLivaData.postValue(NetworkResult.Success(response.body()!!))
             }
            else if (response.isSuccessful && response.body()?.error_code=="203"){
                 Log.d(TAG,response.body()!!.ResponseMessage.toString())
                 _userResponseMutableLivaData.postValue(NetworkResult.Error(response.body()!!.ResponseMessage))
             }

            else{
                _userResponseMutableLivaData.postValue(NetworkResult.Error("something went wrong"))
            }

        }catch (e:Exception){
            Log.e(TAG, "Exception occurred during login: ${e.message}", e)
            _userResponseMutableLivaData.postValue(NetworkResult.Error("An unexpected error occurred"))

        }


    }

    /*..register user..*/
    /* suspend fun registerUser(userRequest: UserRequest){
         val response = userApi.signup(userRequest)
         Log.d(TAG,response.body().toString())

     }*/

}