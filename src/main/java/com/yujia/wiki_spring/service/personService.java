package com.yujia.wiki_spring.service;

import com.yujia.wiki_spring.domain.person;
import com.yujia.wiki_spring.mapper.personMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class personService  {

    @Resource
    private personMapper newperson;

    public List<person> list(){
        return newperson.list() ;
    }
}
