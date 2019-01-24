package org.dnltsk.springbootkotlinstarter

import io.sentry.spring.SentryExceptionResolver
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ApplicationContext
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest()
class SentryExceptionResolverDectivationTest {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Test
    fun `SentryExceptionResolver is disabled by default`() {
        val exceptionResolverBeans = applicationContext.getBeanNamesForType(SentryExceptionResolver::class.java)
        assertThat(exceptionResolverBeans).doesNotContain("sentryExceptionResolver")
    }

}

@RunWith(SpringRunner::class)
@SpringBootTest(properties = arrayOf("sentry.enabled=true", "sentry.dsn=https://01234567890123456789012345678901@sentry.io/1234567"))
class SentryExceptionResolverActivationTest {

    @Autowired
    private lateinit var applicationContext: ApplicationContext

    @Test
    fun `SentryExceptionResolver can be activated`() {
        val exceptionResolverBeans = applicationContext.getBeanNamesForType(SentryExceptionResolver::class.java)
        assertThat(exceptionResolverBeans).contains("sentryExceptionResolver")
    }

}
