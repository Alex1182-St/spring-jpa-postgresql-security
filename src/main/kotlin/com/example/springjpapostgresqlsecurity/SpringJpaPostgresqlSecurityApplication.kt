package com.example.springjpapostgresqlsecurity

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.transaction.annotation.Transactional
import com.example.springjpapostgresqlsecurity.entities.AppUserEntity
import com.example.springjpapostgresqlsecurity.entities.RoleEntity
import com.example.springjpapostgresqlsecurity.entities.RoleEnum
import com.example.springjpapostgresqlsecurity.repositories.AppUserRepository
import com.example.springjpapostgresqlsecurity.repositories.RoleRepository

@SpringBootApplication
class SpringJpaPostgresqlSecurityApplication(

		private val passwordEncoder : PasswordEncoder,
		private val appUserRepo : AppUserRepository,
		private val roleRepo : RoleRepository

) : CommandLineRunner {

	@Transactional
	override fun run(vararg args: String) {
		roleRepo.saveAll(
				listOf(
						RoleEntity(name = RoleEnum.ADMIN, description = "Admin Rights"),
						RoleEntity(name = RoleEnum.USER, description = "User Rights")
				)
		)
		appUserRepo.saveAll(
				listOf(
						AppUserEntity(
								appUserLogin = "TestAdmin1", appUserPassword = passwordEncoder.encode("AdminPass1"),
								email = "Mail-1@ukr.net", appUserSurname = "Proday-Voda", appUserName = "Taras", phone = "097-777-55-66",
								roles = setOf(roleRepo.findByName(RoleEnum.ADMIN))
						),
						AppUserEntity(
								appUserLogin = "TestAdmin2", appUserPassword = passwordEncoder.encode("AdminPass2"),
								email = "Mail-2@ukr.net", appUserSurname = "Nepyy-Pyvo", appUserName = "Oleksandr", phone = "097-777-55-77",
								roles = setOf(roleRepo.findByName(RoleEnum.ADMIN), roleRepo.findByName(RoleEnum.USER))
						)
				)
		)
	}
}


fun main(args: Array<String>) {
	runApplication<SpringJpaPostgresqlSecurityApplication>(*args)
}
