package demo

import demo.bean.*
import org.springframework.beans.factory.annotation.*
import org.springframework.jdbc.core.*
import org.springframework.stereotype.*
import org.springframework.transaction.annotation.*

@Service
class DemoService
@Autowired
constructor(
  private var jdbcTemplate: JdbcTemplate,
) {


  @Transactional
  fun getUser(name: String?): User {


    jdbcTemplate.update("""
      UPDATE test1.order_tbl t SET t.user_id = user_id+1 WHERE t.id = 26
    """.trimIndent())
    val user = User(name, "Hello World")
    return user
  }

}
