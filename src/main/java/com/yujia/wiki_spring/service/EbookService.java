package com.yujia.wiki_spring.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yujia.wiki_spring.domain.Ebook;
import com.yujia.wiki_spring.domain.EbookExample;
import com.yujia.wiki_spring.mapper.EbookMapper;
import com.yujia.wiki_spring.req.Ebookreq;
import com.yujia.wiki_spring.resp.EbookQueryResp;
import com.yujia.wiki_spring.resp.PageResp;
import com.yujia.wiki_spring.util.CopyUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper newEbook;
    private static final Logger log = LoggerFactory.getLogger( EbookService.class );
    public PageResp<EbookQueryResp> list(Ebookreq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria=ebookExample.createCriteria();
        // dynamic SQL
        if(!ObjectUtils.isEmpty(req.getName())) {
        criteria.andNameLike("%"+req.getName()+"%");
        }
        PageHelper.startPage(req.getPage(), req.getSize()); // only useful to first select
        List<Ebook> ebookList=newEbook.selectByExample(ebookExample);

        PageInfo<Ebook> pageInfo =new PageInfo<>(ebookList);
        log.info("rows: {}", pageInfo.getTotal());
        log.info("pages: {}", pageInfo.getPages());

        /*List<EbookQueryResp> respList=new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookQueryResp queryResp=new EbookQueryResp();
            //Copy object:
            EbookQueryResp copy = CopyUtil.copy(ebook, EbookQueryResp.class);

            BeanUtils.copyProperties(ebook,queryResp);
            respList.add(queryResp);
        }*/
        List<EbookQueryResp> respList = CopyUtil.copyList(ebookList, EbookQueryResp.class);
        PageResp<EbookQueryResp> pageResp = new PageResp<>();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(respList);

        return pageResp;
        
    }
}
