package com.yujia.wiki_spring.controller;

import com.yujia.wiki_spring.req.Ebookreq;
import com.yujia.wiki_spring.resp.CommonResp;
import com.yujia.wiki_spring.resp.EbookQueryResp;
import com.yujia.wiki_spring.resp.PageResp;
import com.yujia.wiki_spring.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController //return string or JSON object
//@Controller return pages
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService; // input EbookService

    @GetMapping("/list")
    public CommonResp list(Ebookreq req){
        CommonResp<PageResp<EbookQueryResp>> respond = new CommonResp<>();
        PageResp<EbookQueryResp> list=ebookService.list(req);
        respond.setContent(list);
        return respond;
    }
}
