package demo

import demo.bean.*
import io.seata.spring.annotation.*
import org.springframework.beans.factory.annotation.*
import org.springframework.jdbc.core.*
import org.springframework.stereotype.*

@Service
class DemoService
@Autowired
constructor(
  private val helloServerClient: HelloServerClient,
  private val jdbcTemplate: JdbcTemplate,
) {


  @GlobalTransactional
  fun hello(name: String?): User? {
    val user = helloServerClient.hello1(name)
    val user2 = helloServerClient.hello2(name)
    println("从HelloServer 获取到了一个用户$user")

    jdbcTemplate.update("""
      UPDATE test1.order_tbl t SET t.user_id = user_id+1 WHERE t.id = 28
    """.trimIndent())

    println("从HelloServer 获取到了一个用户$user2")
    throw IllegalStateException()
    return user
  }

}
