package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class EmployeeModel(
    val employeeItem: List<EmployeeItem>
) : Parcelable

@Parcelize
data class EmployeeItem(
    val id: String,
    val ageDob: String,
    val dateDob: String,
    val email: String,
    val gender: String,
    val cityLocation: String,
    val latitudeLocationCoordinates: String,
    val longitudeLocationCoordinates: String,
    val countryLocation: String,
    val stateLocation: String,
    val nameLocationStreet: String,
    val numberLocationStreet: String,
    val descriptionLocationTimezone: String,
    val offsetLocationTimezone: String,
    val md5Login: String,
    val saltLogin: String,
    val sha1Login: String,
    val sha256Login: String,
    val usernameLogin: String,
    val uuidLogin: String,
    val firstName: String,
    val lastName: String,
    val titleName: String,
    val phone: String,
    val largePicture: String,
    val mediumPicture: String,
    val thumbnailPicture: String,
    val ageRegistered: String,
    val dateRegistered: String
) : Parcelable