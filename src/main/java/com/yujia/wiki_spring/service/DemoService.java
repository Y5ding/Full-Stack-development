package com.yujia.wiki_spring.service;

import com.yujia.wiki_spring.domain.Demo;
import com.yujia.wiki_spring.mapper.DemoMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DemoService {

    @Resource
    private DemoMapper newDemo;

    public List<Demo> list(){
        return newDemo.selectByExample(null) ;
    }
}
