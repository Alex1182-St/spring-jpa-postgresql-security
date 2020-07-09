package com.example.springjpapostgresqlsecurity.dtos.outputs
import com.example.springjpapostgresqlsecurity.entities.RoleEnum
import java.util.*

data class RoleOutput(

        val id : UUID,

        val name : RoleEnum,

        val description : String

)
