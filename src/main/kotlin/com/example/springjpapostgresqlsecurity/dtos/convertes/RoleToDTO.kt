package com.example.springjpapostgresqlsecurity.dtos.convertes
import com.example.springjpapostgresqlsecurity.dtos.outputs.RoleOutput
import com.example.springjpapostgresqlsecurity.entities.RoleEntity

fun RoleEntity.toOutput() : RoleOutput = RoleOutput(
    id          = id,
    name        = name,
    description = description
)
