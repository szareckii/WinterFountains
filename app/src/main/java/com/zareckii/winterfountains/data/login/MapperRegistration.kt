package com.zareckii.winterfountains.data.login

import com.zareckii.winterfountains.domain.login.RegistrationDomain

interface MapperRegistration {

    fun map(): RegistrationDomain

    class Base(private val registration: Registration) : MapperRegistration {

        override fun map(): RegistrationDomain {
            return RegistrationDomain(
                errorCode = registration.errorCode,
                error = registration.error
            )
        }
    }
}