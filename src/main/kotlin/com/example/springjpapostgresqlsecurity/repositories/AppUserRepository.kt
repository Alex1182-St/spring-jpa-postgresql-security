package com.example.springjpapostgresqlsecurity.repositories

import com.example.springjpapostgresqlsecurity.entities.AppUserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AppUserRepository : JpaRepository<AppUserEntity, UUID> {

    fun findByEmail(email : String) : Optional<AppUserEntity>

    fun findByAppUserLogin(appUserLogin : String) : Optional<AppUserEntity>

}