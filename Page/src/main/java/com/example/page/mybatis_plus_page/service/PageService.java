package com.example.page.mybatis_plus_page.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.example.page.mybatis_plus_page.entity.PageEntity;
import com.example.page.mybatis_plus_page.entity.Pager;
import org.springframework.stereotype.Service;

/**
* @author Y
* @description 针对表【page】的数据库操作Service
* @createDate 2023-07-15 21:55:11
*/
@Service
public interface PageService extends IService<PageEntity> {

    Pager<PageEntity> page_plus(Long pageIndex, Long paseSize);


}
