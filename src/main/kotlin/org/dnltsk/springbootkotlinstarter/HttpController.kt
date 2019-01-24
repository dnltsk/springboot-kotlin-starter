package org.dnltsk.springbootkotlinstarter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HttpController{

    @Autowired
    private lateinit var requestHandler: RequestHandler

    @GetMapping("/users")
    fun getUsers() : ResponseEntity<UsersResponse>{
        val users = requestHandler.loadUsers()
        return ResponseEntity.ok(UsersResponse(users))
    }

}