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
  @GetMapping("/get")
  fun hello1(@RequestParam("name") name: String?): User {
    //ServiceInstance localInstance = client.getLocalServiceInstance();
    // return "Hello " + name + ": " + localInstance.getServiceId() + ":" +
    // localInstance.getHost() + ":"
    // + localInstance.getPort();
    val user = demoService.getUser(name)
    return user
  }

  @PostMapping("/post")
  fun hello2(@RequestParam("name") name: String?): User {
    //ServiceInstance localInstance = client.getLocalServiceInstance();
    // return "Hello " + name + ": " + localInstance.getServiceId() + ":" +
    // localInstance.getHost() + ":"
    // + localInstance.getPort();

    val user = demoService.getUser(name)
    return user
  }
}


