package com.yujia.wiki_spring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //return string or JSON object
//@Controller return pages
public class TestController {
    @RequestMapping("/hello") //accept all types request
    // GetMapping("use/1") only accept get request
    //GET, POST, PUT, DELETE restful HTTP request
    // use/1 (get userid=1)
    public String hello(){
        return "Hello Word";
    }
}
