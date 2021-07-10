package com.yujia.wiki_spring.service;

import com.yujia.wiki_spring.domain.Ebook;
import com.yujia.wiki_spring.domain.EbookExample;
import com.yujia.wiki_spring.mapper.EbookMapper;
import com.yujia.wiki_spring.req.Ebookreq;
import com.yujia.wiki_spring.resp.EbookQueryResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper newEbook;

    public List<EbookQueryResp> list(Ebookreq req){
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria=ebookExample.createCriteria();
        criteria.andNameLike("%"+req.getName()+"%");
        List<Ebook> ebookList=newEbook.selectByExample(ebookExample);

        List<EbookQueryResp> respList=new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookQueryResp queryResp=new EbookQueryResp();
            BeanUtils.copyProperties(ebook,queryResp);
            respList.add(queryResp);
        }
        return respList;
        
    }
}
