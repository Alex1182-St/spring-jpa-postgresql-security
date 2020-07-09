package com.example.springjpapostgresqlsecurity.controllers

import com.example.springjpapostgresqlsecurity.dtos.convertes.toOutput
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import com.example.springjpapostgresqlsecurity.dtos.outputs.RoleOutput
import com.example.springjpapostgresqlsecurity.repositories.RoleRepository
import javax.transaction.Transactional

@Transactional
@RestController
@RequestMapping("role")
class RoleController (val roleRepo : RoleRepository) {

    @GetMapping("all")
    fun findAll() : Collection<RoleOutput> =
            roleRepo.findAll().map { it.toOutput() }
}