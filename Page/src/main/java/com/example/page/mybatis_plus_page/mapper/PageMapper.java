package com.example.page.mybatis_plus_page.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.page.mybatis_plus_page.entity.PageEntity;
import org.apache.ibatis.annotations.Select;


public interface PageMapper extends BaseMapper<PageEntity> {

    @Select("select * from page")
    Page<PageEntity> page_plus(Page page);
}




