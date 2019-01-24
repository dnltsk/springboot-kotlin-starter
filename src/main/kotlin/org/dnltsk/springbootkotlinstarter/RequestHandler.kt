package org.dnltsk.springbootkotlinstarter

import org.springframework.stereotype.Service
import java.time.Instant

@Service
class RequestHandler {

    fun loadUsers(): List<User> {
        return listOf(
            User("foo", Instant.parse("2019-01-24T16:08:00Z")),
            User("bar", Instant.parse("2019-01-23T03:08:00Z"))
        )
    }

}