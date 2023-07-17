package com.example.page.mybatis_plus_page.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.page.mybatis_plus_page.entity.PageEntity;
import com.example.page.mybatis_plus_page.entity.Pager;
import com.example.page.mybatis_plus_page.mapper.PageMapper;
import com.example.page.mybatis_plus_page.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Y
* @description 针对表【page】的数据库操作Service实现
* @createDate 2023-07-15 21:55:11
*/
@Service
public class PageServiceImpl extends ServiceImpl<PageMapper, PageEntity> implements PageService {

    @Autowired
    private PageMapper pageMapper;
    @Override
    public Pager<PageEntity> page_plus(Long pageIndex, Long paseSize) {
        Page<PageEntity> entityPage = new Page<>(pageIndex, paseSize);
        Page<PageEntity> pageList = pageMapper.page_plus(entityPage);
        return Pager.build(pageList);

    }
}




