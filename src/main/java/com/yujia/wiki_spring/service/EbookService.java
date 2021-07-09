package com.yujia.wiki_spring.service;

import com.yujia.wiki_spring.domain.Ebook;
import com.yujia.wiki_spring.mapper.EbookMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper newEbook;

    public List<Ebook> list(){
        return newEbook.selectByExample(null) ;
    }
}
