package org.dnltsk.springbootkotlinstarter

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.SerializationFeature
import io.sentry.Sentry
import io.sentry.spring.SentryExceptionResolver
import io.sentry.spring.SentryServletContextInitializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty
import org.springframework.boot.web.servlet.ServletContextInitializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestTemplate
import org.springframework.web.servlet.HandlerExceptionResolver
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}

@Configuration
class ApplicationConfiguration {

    @Bean
    fun configureObjectMapper(): ObjectMapper {
        return ObjectMapper()
            .findAndRegisterModules()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
    }

    @Bean
    fun configureRestTemplate(): RestTemplate {
        return RestTemplate()
    }

}

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    fun forecastEndpointsDocket(): Docket {
        return Docket(DocumentationType.SWAGGER_2)
            .apiInfo(
                ApiInfoBuilder().description("# springboot-kotlin-starter 🚀").build()
            )
            .select().apis(
                RequestHandlerSelectors.basePackage("org.dnltsk.springbootkotlinstart")
            ).build()
    }

    @Bean
    fun forwardIndexPagesToSwaggerDoc(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
            override fun addViewControllers(registry: ViewControllerRegistry) {
                registry.addViewController("/").setViewName("redirect:/swagger-ui.html")
                registry.addViewController("/index.html").setViewName("redirect:/swagger-ui.html")
            }
        }
    }

}

@Configuration
@ConditionalOnProperty(prefix = "sentry", name = ["enabled"], havingValue = "true")
class SentryConfiguration {

    @Value("\${sentry.dsn}")
    private val sentryDns: String? = null

    @Bean
    fun sentryExceptionResolver(): HandlerExceptionResolver {
        return SentryExceptionResolver()
    }

    @Bean
    fun sentryServletContextInitializer(): ServletContextInitializer {
        Sentry.init(sentryDns)
        return SentryServletContextInitializer()
    }

}