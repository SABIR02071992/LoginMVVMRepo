package com.cccinfotech.logindemomvvm.api

import com.cccinfotech.logindemomvvm.model.LoginRequest
import com.cccinfotech.logindemomvvm.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApi {
    @POST("user/login")
    suspend fun loginUser (@Body loginRequest: LoginRequest):Response<LoginResponse>
}