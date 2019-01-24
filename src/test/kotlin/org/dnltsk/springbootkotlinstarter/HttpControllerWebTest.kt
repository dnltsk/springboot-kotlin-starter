package org.dnltsk.springbootkotlinstarter

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@RunWith(SpringRunner::class)
@WebMvcTest(HttpController::class)
class HttpControllerWebTest {

    @MockBean
    private lateinit var requestHandler: RequestHandler

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `users endpoint responds with 200 OK`() {
        mockMvc.perform(get("/users"))
            .andExpect(status().isOk)
    }

}
