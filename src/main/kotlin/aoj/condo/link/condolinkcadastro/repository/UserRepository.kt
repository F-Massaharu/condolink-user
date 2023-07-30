package aoj.condo.link.condolinkcadastro.repository

import aoj.condo.link.condolinkcadastro.models.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String> {
    fun findByUsernameAndPassword(username: String, password: String): User?
}