package aoj.condo.link.condolinkcadastro.controller

import aoj.condo.link.condolinkcadastro.service.UserService
import aoj.condo.link.condolinkcadastro.models.User
import org.springframework.web.bind.annotation.*



@RestController
@RequestMapping("/api/users")
class UserController(private val userService: UserService) {
    @PostMapping("/register")
    fun registerUser(@RequestParam username: String, @RequestParam password: String): User {
        return userService.cadastrarUser(username, password)
    }

    @PostMapping("/login")
    fun loginUser(@RequestParam username: String, @RequestParam password: String): User? {
        return userService.loginUser(username, password)
    }
}
