package com.yujia.wiki_spring.controller;

import com.yujia.wiki_spring.domain.person;
import com.yujia.wiki_spring.service.personService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController //return string or JSON object
//@Controller return pages
public class TestController {
    @Value("${test.hello:Test}")
    private String testHello;

    @Resource
    private personService personServices; // input personService

    @GetMapping("/hello") //accept all types request
    // GetMapping("use/1") only accept get request
    //GET, POST, PUT, DELETE restful HTTP request
    // use/1 (get userid=1)
    public String hello(){
        return "Hello World "+testHello;
    }

    @RequestMapping("/query/list")
    public List<person> list(){
        return personServices.list() ;
    }

    @PostMapping("/hello/post")
    //parameter delivery  wrong:Map<String, String> map
    public String helloPost(String name){
        return  "Hello Word ! Post,"+name;
    }
}
