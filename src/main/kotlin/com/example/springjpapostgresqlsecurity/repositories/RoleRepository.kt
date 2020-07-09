package com.example.springjpapostgresqlsecurity.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import com.example.springjpapostgresqlsecurity.entities.RoleEntity
import com.example.springjpapostgresqlsecurity.entities.RoleEnum
import java.util.*

@Repository
interface RoleRepository : JpaRepository<RoleEntity, UUID> {

    fun findByName(name : RoleEnum) : RoleEntity

}