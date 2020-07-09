package com.example.springjpapostgresqlsecurity.dtos.convertes

import com.example.springjpapostgresqlsecurity.dtos.userdetails.AppUserDetailsDTO
import com.example.springjpapostgresqlsecurity.dtos.outputs.AppUserOutput
import com.example.springjpapostgresqlsecurity.entities.AppUserEntity

fun AppUserEntity.toOutput() = AppUserOutput(
        id = id,
        appUserLogin = appUserLogin,
        appUserPassword = appUserPassword,
        roles = roles.map { it.id },
        email = email,
        appUserSurname = appUserSurname,
        appUserName = appUserName,
        skype = skype,
        userAge = userAge
)

fun AppUserEntity.toAppUserDetailsDTO() = AppUserDetailsDTO(
        id = id,
        username = appUserLogin,
        password = appUserPassword,
        authorities = roles.map { it.name },
        isEnabled               = isEnabled,
        isAccountNonLocked      = isAccountNonLocked,
        isAccountNonExpired     = isAccountNonExpired,
        isCredentialsNonExpired = isCredentialsNonExpired
)