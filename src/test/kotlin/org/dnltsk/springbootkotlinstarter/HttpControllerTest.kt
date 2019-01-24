package org.dnltsk.springbootkotlinstarter

import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.time.Instant

@SpringBootTest
@RunWith(SpringRunner::class)
class HttpControllerTest{

    @InjectMocks
    private lateinit var httpController: HttpController

    @Mock
    private lateinit var requestHandler: RequestHandler

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `request is forwarded to RequestHandler`() {
        httpController.getUsers()
        verify(requestHandler).loadUsers()
    }

    @Test
    fun `list of users is surrounded by response object`() {
        val users = listOf(
            User("username", Instant.parse("2019-01-24T16:05:00Z")),
            User("username", Instant.parse("2019-01-01T00:00:00Z"))
        )
        whenever(requestHandler.loadUsers()).thenReturn(users)

        val response = httpController.getUsers()

        assertThat(response.body!!.users).isEqualTo(users)
    }
}