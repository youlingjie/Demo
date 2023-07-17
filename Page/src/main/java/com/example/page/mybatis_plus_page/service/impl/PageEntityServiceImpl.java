package com.example.page.mybatis_plus_page.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.page.mybatis_plus_page.entity.PageEntity;
import com.example.page.mybatis_plus_page.service.PageEntityService;
import com.example.page.mybatis_plus_page.mapper.PageEntityMapper;
import org.springframework.stereotype.Service;

/**
* @author Y
* @description 针对表【page】的数据库操作Service实现
* @createDate 2023-07-15 21:55:11
*/
@Service
public class PageEntityServiceImpl extends ServiceImpl<PageEntityMapper, PageEntity>
    implements PageEntityService{

}




