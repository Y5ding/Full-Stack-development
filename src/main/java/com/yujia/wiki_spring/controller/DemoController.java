package com.yujia.wiki_spring.controller;

import com.yujia.wiki_spring.domain.Demo;
import com.yujia.wiki_spring.service.DemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //return string or JSON object
//@Controller return pages
@RequestMapping("/ebook")
public class DemoController {
    @Resource
    private DemoService DemoServices; // input DemoService

    @RequestMapping("/list")
    public List<Demo> list(){
        return DemoServices.list() ;
    }
}
