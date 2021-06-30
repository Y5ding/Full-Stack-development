package com.yujia.wiki_spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //return string or JSON object
//@Controller return pages
public class TestController {
    @Value("${test.hello:Test}")
    private String testHello;
    @GetMapping("/hello") //accept all types request
    // GetMapping("use/1") only accept get request
    //GET, POST, PUT, DELETE restful HTTP request
    // use/1 (get userid=1)
    public String hello(){
        return "Hello World "+testHello;
    }
    @PostMapping("/hello/post")
    //parameter delivery  wrong:Map<String, String> map
    public String helloPost(String name){
        return  "Hello Word ! Post,"+name;
    }
}
