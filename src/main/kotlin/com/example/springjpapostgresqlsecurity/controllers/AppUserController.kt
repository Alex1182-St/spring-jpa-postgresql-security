package com.example.springjpapostgresqlsecurity.controllers


import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.security.core.userdetails.UsernameNotFoundException
import com.example.springjpapostgresqlsecurity.dtos.convertes.toOutput
import com.example.springjpapostgresqlsecurity.dtos.outputs.AppUserOutput
import com.example.springjpapostgresqlsecurity.repositories.AppUserRepository
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.transaction.Transactional

@Transactional
@RestController
@RequestMapping("app")
class AppUserController  (val appUserRepo : AppUserRepository) {


    @PostMapping("byMail")
    @PreAuthorize("hasAnyRole('ADMIN')")
    fun appUserByMailWithPost(@RequestBody bodyWithEmail: Map<String, Any>): AppUserOutput {

        return appUserRepo.findByEmail(bodyWithEmail.get("appUserEmail") as String)
                .map { it.toOutput() }
                .orElseThrow {
                    Exception("User with such email is not present in the database")
                }
    }


    @PostMapping("byId")
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    fun appUserByIdWithPost(@RequestBody bodyWithUUID: Map<String, Any>): AppUserOutput {

        val id = UUID.fromString(bodyWithUUID.get("id") as String)

        return appUserRepo.findById(UUID.fromString(bodyWithUUID.get("id") as String))
                .map { it.toOutput() }
                .orElseThrow {
                    UsernameNotFoundException("User not found with id: $id")
                }
    }
    }

