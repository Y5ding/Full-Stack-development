package com.yujia.wiki_spring.controller;

import com.yujia.wiki_spring.domain.Ebook;
import com.yujia.wiki_spring.resp.CommonResp;
import com.yujia.wiki_spring.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController //return string or JSON object
//@Controller return pages
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService; // input EbookService

    @GetMapping("/list")
    public CommonResp list(){
        CommonResp<List<Ebook>> respond = new CommonResp<>();
        List<Ebook> list=ebookService.list();
        respond.setContent(list);
        return respond;
    }
}
