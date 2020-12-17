package demo

import demo.bean.*
import io.seata.spring.annotation.*
import org.springframework.beans.factory.annotation.*
import org.springframework.web.bind.annotation.*

@RestController
class DemoHandler
@Autowired
constructor(
  private val demoService: DemoService
) {

  @RequestMapping("/")
  fun hello(@RequestParam("name") name: String?): User? {

    return demoService.hello(name)

  }
}
