package com.yujia.wiki_spring.controller;

import com.yujia.wiki_spring.domain.Ebook;
import com.yujia.wiki_spring.service.EbookService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //return string or JSON object
//@Controller return pages
@RequestMapping("/Ebook")
public class EbookController {
    @Resource
    private EbookService ebookService; // input EbookService

    @RequestMapping("/list")
    public List<Ebook> list(){
        return ebookService.list();
    }
}
