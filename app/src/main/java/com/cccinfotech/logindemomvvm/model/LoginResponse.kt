package com.cccinfotech.logindemomvvm.model

data class LoginResponse(
    val ApiUrl: Any,
    val ApiVersion: Any,
    val Auth: Boolean,
    val AuthToken: String,
    val ResponseCode: String,
    val ResponseMessage: String,
    val Success: Boolean,
    val User: User,
    val error_message:String,
    val error_code:String,
    val UserId: String
)