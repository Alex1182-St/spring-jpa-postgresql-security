package com.example.springjpapostgresqlsecurity.services

import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service
import com.example.springjpapostgresqlsecurity.dtos.userdetails.AppUserDetailsDTO
import com.example.springjpapostgresqlsecurity.dtos.convertes.toAppUserDetailsDTO
import com.example.springjpapostgresqlsecurity.repositories.AppUserRepository
import javax.transaction.Transactional


@Transactional
@Service
class AppUserDetailsService (val appUserRepo : AppUserRepository) : UserDetailsService {

    override fun loadUserByUsername(login: String): AppUserDetailsDTO {
        return appUserRepo.findByAppUserLogin(login)
                .map { it.toAppUserDetailsDTO() }
                .orElseThrow { UsernameNotFoundException("User not found with login: $login") }
    }
}