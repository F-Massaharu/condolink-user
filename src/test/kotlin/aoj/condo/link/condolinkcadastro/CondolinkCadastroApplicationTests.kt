package aoj.condo.link.condolinkcadastro

import aoj.condo.link.condolinkcadastro.models.User
import aoj.condo.link.condolinkcadastro.repository.UserRepository
import aoj.condo.link.condolinkcadastro.service.UserService
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CondolinkCadastroApplicationTests {
	private val userRepository: UserRepository = mockk()
	private val userService = UserService(userRepository)

	@Test
	fun testRegisterUser() {
		val newUser = User(username = "john_doe", password = "password")
		val savedUser = User(id = "1", username = "john_doe", password = "password")

		every { userRepository.save(newUser) } returns savedUser

		val registeredUser = userService.cadastrarUser("john_doe", "password")

		assertEquals(savedUser, registeredUser)
	}

	@Test
	fun testLoginUser() {
		val existingUser = User(id = "1", username = "john_doe", password = "password")

		every { userRepository.findByUsernameAndPassword("john_doe", "password") } returns existingUser

		val loggedInUser = userService.loginUser("john_doe", "password")

		assertEquals(existingUser, loggedInUser)
	}
}