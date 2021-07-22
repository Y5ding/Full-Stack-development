package com.yujia.wiki_spring.controller;

import com.yujia.wiki_spring.req.EbookSaveReq;
import com.yujia.wiki_spring.req.Ebookreq;
import com.yujia.wiki_spring.resp.CommonResp;
import com.yujia.wiki_spring.resp.EbookQueryResp;
import com.yujia.wiki_spring.resp.PageResp;
import com.yujia.wiki_spring.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@RestController //return string or JSON object
//@Controller return pages
@RequestMapping("/ebook")
public class EbookController {
    @Resource
    private EbookService ebookService; // input EbookService

    @GetMapping("/list")
    public CommonResp list(@Valid Ebookreq req){
        CommonResp<PageResp<EbookQueryResp>> respond = new CommonResp<>();
        PageResp<EbookQueryResp> list=ebookService.list(req);
        respond.setContent(list);
        return respond;
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req){
        CommonResp respond = new CommonResp<>();
        ebookService.save(req);
        return respond;
    }
    @DeleteMapping("/delete/{id}")
    public CommonResp delete(@PathVariable Long id){
        CommonResp respond = new CommonResp<>();
        ebookService.delete(id);
        return respond;
    }
}
