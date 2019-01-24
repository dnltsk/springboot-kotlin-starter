package org.dnltsk.springbootkotlinstarter

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class SwaggerWebTest {

    @Autowired
    private lateinit var testRestTemplate: TestRestTemplate

    @Test
    fun `root path responds with Swagger UI`() {
        val response = testRestTemplate.getForEntity("/", String::class.java)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body).contains("Swagger UI")
    }

}
