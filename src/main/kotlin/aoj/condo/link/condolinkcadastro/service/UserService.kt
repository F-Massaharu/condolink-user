package aoj.condo.link.condolinkcadastro.service

import aoj.condo.link.condolinkcadastro.repository.UserRepository
import aoj.condo.link.condolinkcadastro.models.User
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun cadastrarUser(username: String, password: String): User {
        val user = User(username = username, password = password)
        return userRepository.save(user)
    }

    fun loginUser(username: String, password: String): User? {
        return userRepository.findByUsernameAndPassword(username, password)
    }
}
