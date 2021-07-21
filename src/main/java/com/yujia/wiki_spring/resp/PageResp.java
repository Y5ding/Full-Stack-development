package com.yujia.wiki_spring.resp;

import java.util.List;

public class PageResp<T> {
    //typically it's same as ebook except for sensitive words
    private Long total;

    private List<T> list;

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("PageResp{");
        sb.append("total=").append(total);
        sb.append(", list=").append(list);
        sb.append('}');
        return sb.toString();
    }
}
