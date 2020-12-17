package demo

import feign.*
import io.seata.rm.datasource.*
import org.springframework.beans.factory.annotation.*
import org.springframework.boot.*
import org.springframework.boot.autoconfigure.*
import org.springframework.boot.autoconfigure.jdbc.*
import org.springframework.cloud.client.discovery.*
import org.springframework.cloud.openfeign.*
import org.springframework.context.annotation.*
import javax.sql.*

@SpringBootApplication(exclude = [DataSourceAutoConfiguration::class])
@EnableDiscoveryClient
@EnableFeignClients
class HelloClientApplication {

  @Bean
  fun feignLoggerLevel(): Logger.Level {
    return Logger.Level.FULL
  }

}

fun main(args: Array<String>) {
  SpringApplication.run(HelloClientApplication::class.java, *args)
}
