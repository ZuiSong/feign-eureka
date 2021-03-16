package sample.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

  @RequestMapping("/{path}")
  public String hello(@PathVariable(required = false) String path) {
    String s = "hello world, " + path;
    System.out.println(s);
    return s;
  }

}
