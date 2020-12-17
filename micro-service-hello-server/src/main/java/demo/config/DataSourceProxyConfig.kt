package demo.config

import com.zaxxer.hikari.*
import io.seata.rm.datasource.*
import org.springframework.beans.factory.*
import org.springframework.boot.context.properties.*
import org.springframework.context.annotation.*
import javax.sql.*

@Configuration
class DataSourceProxyConfig {
  @Bean
  @ConfigurationProperties(prefix = "spring.datasource.hikari")
  fun baseDataSource(): DataSource = HikariDataSource()

  @Primary
  @Bean
  fun dataSource(): DataSourceProxy = DataSourceProxy(baseDataSource())


  @Bean
  fun init(dataSource: DataSource): InitializingBean = InitializingBean {
    println("ds---${dataSource::class.java}")
  }
}
