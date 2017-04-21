package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Spencer Gibb
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
@EnableFeignClients
public class HelloClientApplication {
	@Autowired
	HelloClient client;

	@RequestMapping("/")
	public String hello(@RequestParam("name") String name) {
		User user = client.hello1(name);
		User user2 = client.hello2(name);
		System.out.println("从HelloServerh获取到了一个用户" + user + user2);
		return user.toString();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloClientApplication.class, args);
	}

	@FeignClient("HelloServer")
	interface HelloClient {
		@RequestMapping(value = "/get", method = RequestMethod.GET)
		@ResponseBody
		public User hello1(@RequestParam("name") String name);

		@RequestMapping(value = "/post", method = RequestMethod.POST)
		@ResponseBody
		public User hello2(@RequestParam("name") String name);
	}
}
