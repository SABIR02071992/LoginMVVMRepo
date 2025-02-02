package com.cccinfotech.logindemomvvm.model

data class User(
    val AboutMe: String,
    val Address: String,
    val AssignExpenseAmount: String,
    val AutoCheckOutTime: String,
    val BannerPhotoUrl: String,
    val City: String,
    val CommunityNickname: String,
    val CompanyName: String,
    val Country: Int,
    val CreatedById: String,
    val Created_at: String,
    val Created_by: String,
    val CrmId: String,
    val CrmIdTemp: String,
    val Department: String,
    val Email: String,
    val EmailVerified: String,
    val FirstName: String,
    val IsDeleted: Int,
    val IsTeam: Boolean,
    val LastName: String,
    val LicenseCount: Int,
    val ManagerId: String,
    val ManagerName: String,
    val MapTrackingTime: Int,
    val Mobile: String,
    val ModifiedDate: String,
    val OtpCreatedDate: String,
    val OtpVerified: Int,
    val PostalCode: String,
    val ProfileId: String,
    val ProfileName: String,
    val RoleId: String,
    val State: String,
    val Status: String,
    val TeamList: List<Team>,
    val Updated_at: String,
    val Updated_by: String,
    val UserId: String,
    val UserNameId: String,
    val UserProfileAccess: List<UserProfileAcces>,
    val UserProfileImage: String,
    val UserType: String,
    val id: Int,
    val isActive: Int,
    val user_permission: UserPermission
)