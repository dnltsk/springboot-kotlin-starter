package org.dnltsk.springbootkotlinstarter

import java.time.Instant

data class User(
    val name: String,
    val lastLogin: Instant
)

data class UsersResponse(
    val users: List<User>
)