package com.yujia.wiki_spring.domain;

import javax.xml.crypto.Data;

public class person {
    private Integer id;
    private String name;
    private String password;
    private Data birthday;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Data getBirthday() {
        return birthday;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void setBirthday(Data birthday) {
        this.birthday = birthday;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
