package com.example.data.source.employee.mapper

import com.example.data.entity.EmployeeEntity
import com.example.domain.model.EmployeeItem
import com.example.domain.model.EmployeeModel

class EmployeeMapperImpl : EmployeeMapper {

    override fun toEmployee(entity: EmployeeEntity) =
        with(entity.results) {
            EmployeeModel(
                employeeItem = this.map {
                    EmployeeItem(
                        id = it.id.value.orEmpty(),
                        ageDob = it.dob.age.toString().orEmpty(),
                        dateDob = it.dob.date.orEmpty(),
                        email = it.email.orEmpty(),
                        gender = it.gender.orEmpty(),
                        cityLocation = it.location.city.orEmpty(),
                        latitudeLocationCoordinates = it.location.coordinates.latitude.orEmpty(),
                        longitudeLocationCoordinates = it.location.coordinates.longitude.orEmpty(),
                        countryLocation = it.location.country.orEmpty(),
                        stateLocation = it.location.state.orEmpty(),
                        nameLocationStreet = it.location.street.name.orEmpty(),
                        numberLocationStreet = it.location.street.number.toString().orEmpty(),
                        descriptionLocationTimezone = it.location.timezone.description.orEmpty(),
                        offsetLocationTimezone = it.location.timezone.offset.orEmpty(),
                        md5Login = it.login.md5.orEmpty(),
                        saltLogin = it.login.salt.orEmpty(),
                        sha1Login = it.login.sha1.orEmpty(),
                        sha256Login = it.login.sha256.orEmpty(),
                        usernameLogin = it.login.username.orEmpty(),
                        uuidLogin = it.login.uuid.orEmpty(),
                        firstName = it.name.first.orEmpty(),
                        lastName = it.name.last.orEmpty(),
                        titleName = it.name.title.orEmpty(),
                        phone = it.phone.orEmpty(),
                        largePicture = it.picture.large.orEmpty(),
                        mediumPicture = it.picture.medium.orEmpty(),
                        thumbnailPicture = it.picture.thumbnail.orEmpty(),
                        ageRegistered = it.registered.age.toString().orEmpty(),
                        dateRegistered = it.registered.date.orEmpty(),
                    )
                }
            )
        }
}