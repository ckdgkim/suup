package com.example.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

  @GetMapping
  public String hello(@RequestParam(value = "msg", required = true, defaultValue = "world") String msg) { // /hello?msg=hello
    return "Hello, World! = get : query parameter = " + msg;
  }

  @GetMapping("/{msg}")
  public String helloPathVar(@PathVariable("msg") String msg) { // /hello/{msg}
    return "Hello, World! = get : path variable = " + msg;
  }

  @PostMapping
  public String hello2(@RequestBody Person person) {
    String result = "post " + person.getName() + "," + person.getAge();
    return result;
  }

//  public String hello2(@RequestParam String name, @RequestParam int age) {
//    String result ="post " + name + "," + age;
//    return result;
//  }

  @PutMapping
  public String hello3(@ModelAttribute Person person) {
    return "hello, world = put " + person.getName() + "," + person.getAge();
  }

  @PatchMapping
  public String hello4() {
    return "hello, world = patch";
  }

  @DeleteMapping
  public String hello5() {
    return "hello, world = delete";
  }
}
